package com.sli.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name="LoginServlet", urlPatterns="/Hello")
public class Hello extends HttpServlet {
    private ServletConfig config;
    private static int counter = 0;

    public Hello() {
        super();
        System.out.println("=== " + ++counter + " instances ===");
    }

    //初始化servlet
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
        System.out.println("=== invoke init() ===" + new Date().toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=== invoke doPost ===" + new Date().toString());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=== invoke doGet() ===" + new Date().toString());
//        String str = this.config.getServletName();
        String str = "haha123";
        List<String> list =  new ArrayList<>();
        list.add(str);
        request.setAttribute("list",list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
//        response.getOutputStream().write(str.getBytes());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("=== invoke service ===");
    }

    @Override
    public void destroy() {
        System.out.println("=== invoke destroy() ===" + new Date().toString());
    }
}