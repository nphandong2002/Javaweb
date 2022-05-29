package com.example.demo.controller;


import com.example.demo.dao.employessDao;
import com.example.demo.model.employess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "home", urlPatterns = "/home")
public class home extends HttpServlet {
    employessDao dao = new employessDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String msg = insertEmployess();
        request.setAttribute("employess", getListEmployess());
        request.setAttribute("messger", msg);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected List<employess>  getListEmployess() {
        List<employess> list = dao.getEmployess();
        return list;
    }

    private String insertEmployess() {
        employess e = new employess();
        return dao.insertEmployess(e);
    }
}
