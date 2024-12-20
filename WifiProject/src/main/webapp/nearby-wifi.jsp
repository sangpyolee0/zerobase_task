<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.wifi.DatabaseService" %>
<%@ page import="java.util.List" %>

<%
    String lat = request.getParameter("lat");
    String lnt = request.getParameter("lnt");

    if (lat == null || lnt == null) {
        response.getWriter().write("[]");
        return;
    }

    DatabaseService dbService = new DatabaseService();
    List<String[]> wifiList = dbService.getNearbyWifi(lat, lnt);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    out.print("[");
    for (int i = 0; i < wifiList.size(); i++) {
        String[] wifi = wifiList.get(i);
        out.print("{");
        out.print("\"distance\": \"" + wifi[0] + "\",");
        out.print("\"name\": \"" + wifi[1] + "\",");
        out.print("\"address\": \"" + wifi[2] + "\",");
        out.print("\"lat\": \"" + wifi[3] + "\",");
        out.print("\"lnt\": \"" + wifi[4] + "\"");
        out.print("}");
        if (i < wifiList.size() - 1) out.print(",");
    }
    out.print("]");
%>
