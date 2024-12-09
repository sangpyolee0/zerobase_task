package com.example.wifi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/wifi_project";
    private static final String DB_USER = "mission1";
    private static final String DB_PASSWORD = "zerobase";

    
    
    // 히스토리 저장
    public void saveHistory(String lat, String lnt) {
        String query = "INSERT INTO location_history (lat, lnt) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, lat);
            pstmt.setString(2, lnt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 히스토리 목록 가져오기
    public List<String[]> getHistoryList() {
        List<String[]> historyList = new ArrayList<>();
        String query = "SELECT id, lat, lnt, date FROM location_history ORDER BY date DESC";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String[] history = new String[4];
                history[0] = rs.getString("id");       // ID
                history[1] = rs.getString("lat");      // LAT
                history[2] = rs.getString("lnt");      // LNT
                history[3] = rs.getString("date");     // 조회 날짜
                historyList.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historyList;
    }

    // 히스토리 삭제
    public boolean deleteHistoryById(int id) {
        String query = "DELETE FROM location_history WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 와이파이 데이터 저장
    public void saveWifiData(JsonArray wifiList) {
        String query = "INSERT INTO wifi_data (wifiName, address, distance, lat, lnt) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            for (int i = 0; i < wifiList.size(); i++) {
                JsonObject wifi = wifiList.get(i).getAsJsonObject();
                pstmt.setString(1, wifi.get("X_SWIFI_MGR_NO").getAsString());
                pstmt.setString(2, wifi.get("X_SWIFI_WRDOFC").getAsString());
                pstmt.setDouble(3, 0.0); // 기본 거리값
                pstmt.setString(4, wifi.get("LAT").getAsString());
                pstmt.setString(5, wifi.get("LNT").getAsString());
                pstmt.addBatch();
            }
            pstmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 근처 와이파이 정보 가져오기 (항상 최대 20개)
    public List<String[]> getNearbyWifi(String lat, String lnt) {
        List<String[]> resultList = new ArrayList<>();
        String query = "SELECT wifiName, address, " +
                       "ST_Distance_Sphere(Point(lnt, lat), Point(?, ?)) AS distance, lat, lnt " +
                       "FROM wifi_data " +
                       "ORDER BY distance LIMIT 20";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, lnt);
            pstmt.setString(2, lat);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String[] wifiInfo = new String[5];
                    wifiInfo[0] = rs.getString("distance");
                    wifiInfo[1] = rs.getString("wifiName");
                    wifiInfo[2] = rs.getString("address");
                    wifiInfo[3] = rs.getString("lat");
                    wifiInfo[4] = rs.getString("lnt");
                    resultList.add(wifiInfo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }




}