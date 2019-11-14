package com.lxf.logback.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * @program: logback-demo
 * @description:
 * @author: lxf
 * @create: 2019-11-11 14:27
 **/
@WebServlet( name = "helloServlet" , urlPatterns = "/hello1")
public class ServletDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("t","ssssss");
        req.setAttribute("s","ttttttt");
req.getRequestDispatcher("/demo.jsp").forward(req,resp);

    }
}
