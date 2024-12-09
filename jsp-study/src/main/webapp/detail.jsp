<%@page import="db.Member"%>
<%@page import="java.util.List"%>
<%@page import="db.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세</title>
<style>
table {
    width: 100%;
    border-collapse: collapse; /* 테두리가 겹치지 않게 설정 */
}
th, td {
    border: 1px solid #000; /* 검은색 테두리 */
    text-align: center; /* 텍스트 가운데 정렬 */
    padding: 8px; /* 내용 여백 */
}
thead th {
    background-color: #f2f2f2; /* 연한 회색 배경 */
    font-weight: bold;
}
</style>
</head>
<body>
    <%
    String memberType = request.getParameter("memberType");
    String userId = request.getParameter("userId");

    if (memberType == null || memberType.isEmpty() || userId == null || userId.isEmpty()) {
    %>
        <p>회원구분과 아이디가 필요합니다. <a href="list.jsp">목록으로 이동</a></p>
    <%
        return;
    }

    MemberService memberService = new MemberService();
    Member member = memberService.detail(memberType, userId);

    if (member == null) {
    %>
        <p>해당 회원 정보를 찾을 수 없습니다. <a href="list.jsp">목록으로 이동</a></p>
    <%
        return;
    }
    %>

    <h1>회원 상세</h1>
    <table>
        <colgroup>
            <col style="width: 20%;">
            <col style="width: 80%;">
        </colgroup>
        <tbody>
            <tr>
                <th>회원구분</th>
                <td><%= member.getMemberType() %></td>
            </tr>
            <tr>
                <th>아이디</th>
                <td><%= member.getUserId() %></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><%= member.getName() %></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><%= member.getPassword() %></td>
            </tr>
            <tr>
                <th>마케팅 수신여부</th>
                <td><%= member.isMarketingYN() ? "동의" : "미동의" %></td>
            </tr>
            <tr>
                <th>가입일</th>
                <td><%= member.getRegisterDate() %></td>
            </tr>
        </tbody>
    </table>

    <div>
        <a href="list.jsp">목록으로 이동</a>
    </div>
</body>
</html>
