package com.taraskina.hw_custom_tag;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "StudentServlet", value = "/hello-student")
public class StudentServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentMap students = new StudentMap();
        req.setAttribute("st", students) ;
        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }
}