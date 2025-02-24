<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% // 자바 코드 삽입부

  // memberRepository 불러오기, request, response 는 사용 가능
  MemberRepository memberRepository = MemberRepository.getInstance();

  // 파라미터로 입력받은 데이터 가져오기
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  // 비즈니스 로직: 멤버 저장
  Member member = new Member(username, age);
  memberRepository.save(member);

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></li>
  <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
