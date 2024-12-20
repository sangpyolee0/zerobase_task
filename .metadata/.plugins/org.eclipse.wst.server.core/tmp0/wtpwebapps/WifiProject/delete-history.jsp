<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 클라이언트에서 전달받은 ID 가져오기
    int id = Integer.parseInt(request.getParameter("id"));

    // DatabaseService 인스턴스 생성 및 삭제 메서드 호출
    com.example.wifi.DatabaseService dbService = new com.example.wifi.DatabaseService();
    boolean success = dbService.deleteHistoryById(id);

    // 삭제 성공 여부에 따라 상태 반환
    if (success) {
        response.setStatus(HttpServletResponse.SC_OK); // 성공
    } else {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 실패
    }
%>