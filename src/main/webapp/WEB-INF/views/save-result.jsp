<%--<%@ page import="hello.servlet.domain.member.Member" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>
성공
<ul>

<%--  <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>--%>
<%--  <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>--%>
<%--  <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>--%>

  <%--  위의 request.getAttribute 방식은 코드가 복잡하다. 모델에 "member"를 담아 가져왔으므로 바로 사용 가능하다--%>
  <li>id=${member.id}</li> <!--request.getAttribute()로 member를 호출하고, getId()를 호출-->
  <li>username=${member.username}</li>
  <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
