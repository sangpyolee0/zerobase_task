package com.example.wifi;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WifiApiService {
    private static final String API_KEY = "494f4e5359746b64363343416b4352";

    public JsonObject fetchWifiData(int start, int end) throws Exception {
        String apiUrl = "http://openapi.seoul.go.kr:8088/" + API_KEY + "/json/TbPublicWifiInfo/" + start + "/" + end + "/";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("API 호출 실패: 응답 코드 " + responseCode);
        }

        try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
            JsonObject response = JsonParser.parseReader(reader).getAsJsonObject();
            System.out.println("API 응답: " + response.toString()); // 응답 내용 출력
            if (response.has("TbPublicWifiInfo")) {
                return response.getAsJsonObject("TbPublicWifiInfo");
            } else {
                throw new Exception("API 응답에 'TbPublicWifiInfo' 키가 없습니다.");
            }
        } catch (Exception e) {
            throw new Exception("API 호출 중 오류 발생: " + e.getMessage());
        }
    }

}