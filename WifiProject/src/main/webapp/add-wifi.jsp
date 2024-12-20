<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.wifi.WifiApiService" %>
<%@ page import="com.example.wifi.DatabaseService" %>
<%@ page import="com.google.gson.JsonObject" %>
<%@ page import="com.google.gson.JsonArray" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 데이터 저장</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/add-wifi.css">
</head>
<body>
    <div class="container">
        <%
            WifiApiService apiService = new WifiApiService();
            DatabaseService dbService = new DatabaseService();

            try {
                JsonObject wifiResponse = apiService.fetchWifiData(1, 1000); // API 호출
                if (wifiResponse != null && wifiResponse.has("list_total_count")) {
                    int totalCount = wifiResponse.get("list_total_count").getAsInt(); // 총 데이터 개수 가져오기
                    JsonArray wifiList = wifiResponse.getAsJsonArray("row");
                    dbService.saveWifiData(wifiList); // DB에 데이터 저장
                    
                    out.println("<h2>" + totalCount + "개의 WIFI 정보를 정상적으로 저장하였습니다!</h2>");
                } else {
                    out.println("<h2>JSON 응답에 'list_total_count' 키가 없습니다.</h2>");
                }
            } catch (Exception e) {
                out.println("<h2>오류 발생: " + e.getMessage() + "</h2>");
            }
        %>
        <nav>
            <a href="index.jsp">홈으로 가기</a>
        </nav>
    </div>
</body>
</html>