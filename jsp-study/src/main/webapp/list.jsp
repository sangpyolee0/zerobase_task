<%@page import="db.Member"%>
<%@page import="java.util.List"%>
<%@page import="db.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
/* 테이블 스타일 */
table {
    width: 100%;
    border-collapse: collapse; /* 테두리가 겹치지 않게 설정 */
}

/* 테두리 설정 */
th, td {
    border: 1px solid #000; /* 검은색 테두리 */
    text-align: center; /* 텍스트 가운데 정렬 */
    padding: 8px; /* 내용 여백 */
}

/* 헤더 스타일 */
thead th {
    background-color: #f2f2f2; /* 연한 회색 배경 */
    font-weight: bold;
}
</style>
</head>
<body>
    <%
    MemberService memberService = new MemberService();
    List<Member> memberList = memberService.list();
    %>

    <h1>회원 목록</h1>
    <table>
        <thead>
            <tr>
                <th>회원구분</th>
                <th>아이디</th>
                <th>이름</th>
                <th>비밀번호</th>
            </tr>
        </thead>
        <tbody>
            <%
            for (Member member : memberList) {
            %>
            <tr>
                <td><%= member.getMemberType() %></td>
                <td>
                    <a href="detail.jsp?memberType=<%= member.getMemberType() %>&userId=<%= member.getUserId() %>">
                        <%= member.getUserId() %>
                    </a>
                </td>
                <td><%= member.getName() %></td>
                <td><%= member.getPassword() %></td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>
    
    <div>
    	<a href ="add.jsp"> 회원 추가 </a> 
    	</div>
</body>
</html>

