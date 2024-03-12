package ar.org.centro8.colegio.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "ipServer", urlPatterns = "/ipServer")
public class IpServer extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println("****************************************");
        //System.out.println(request.getRemoteAddr());
        //System.out.println("****************************************");
        //192.168.20.198:8095/ipServer
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/plain");
        response.getWriter().print(request.getRemoteAddr());
    }
    
}
