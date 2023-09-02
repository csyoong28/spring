package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        servletConfig = config;
        String initParam  = config.getInitParameter("InitParam");
        System.out.println(initParam);
    }

    //or
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String initParam  = servletConfig.getInitParameter("InitParam");
        //String initParam = getServletConfig().getInitParameter("InitParam"); // will fail
        System.out.println(initParam);
    }

}
