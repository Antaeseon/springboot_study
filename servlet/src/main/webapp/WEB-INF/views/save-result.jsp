<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
<%--    자동으로 getId가 호출된다.--%>
    <li>
        id=${member.id}
    </li>
    <li>
        username=${member.username}
    </li>
    <li>
        age=${member.age}
    </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
