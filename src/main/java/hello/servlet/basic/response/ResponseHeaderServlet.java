package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]응답 상태 코드 지정
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        // [response-headers]
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        // 개발자모드에서 Network, Headers, Response Headers 를 보면
        // 상태코드, Cache-Control, Content-Type, Pragma, My-header 모두 설정한 대로 보이는 것을 확인할 수 있다.
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("My-header", "hello");

        // [Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);

        // message body
        response.getWriter().println("ok");
    }

    // [Header 편의 메서드]: Header 설정
    private void content(HttpServletResponse response){
        // Content-Type: text/plain;charset=utf-8
        // Content-Length: 2
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(2); // 생략시 자동 생성
    }

    // [Header 편의 메서드]: Cookie 설정
    private void cookie(HttpServletResponse response){
        // Set-Cookie: myCookie=good; Max-age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    // [Header 편의 메서드]: redirect 설정
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
