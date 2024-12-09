<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wifi.DatabaseService" %>
<!DOCTYPE html>
<html>
<head>
    <title>위치 히스토리 목록</title>
    <link rel="stylesheet" type="text/css" href="css/history.css">
    <script>
        function deleteHistory(id) {
            if (confirm("정말 삭제하시겠습니까?")) {
                fetch(`delete-history.jsp?id=${id}`, { method: "GET" })
                    .then(response => {
                        if (response.ok) {
                            alert("삭제되었습니다!");
                            location.reload(); // 페이지 새로고침
                        } else {
                            alert("삭제 중 오류가 발생했습니다.");
                        }
                    })
                    .catch(err => alert("서버 연결에 실패했습니다."));
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <header>
            <h1>위치 히스토리 목록</h1>
            <nav>
                <a href="index.jsp">홈</a>
                <span>|</span>
                <a href="add-wifi.jsp">Open API 와이파이 정보 가져오기</a>
                <span>|</span>
                <a href="history.jsp">위치 히스토리 목록</a>
            </nav>
        </header>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>X좌표</th>
                    <th>Y좌표</th>
                    <th>조회일자</th>
                    <th>비고</th>
                </tr>
            </thead>
            <tbody>
                <%
                    DatabaseService dbService = new DatabaseService();
                    List<String[]> historyList = dbService.getHistoryList();
                    for (String[] history : historyList) {
                %>
                <tr>
                    <td><%= history[0] %></td>
                    <td><%= history[1] %></td>
                    <td><%= history[2] %></td>
                    <td><%= history[3] %></td>
                    <td><button class="delete" onclick="deleteHistory(<%= history[0] %>)">삭제</button></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
