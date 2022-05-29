package com.example.demo3.controller;

import com.example.demo3.dao.employessDao;
import com.example.demo3.model.employess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class home extends HttpServlet {
    private employessDao dao = new employessDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String action = req.getParameter("type");

        switch (action) {
            case "add": {
                String name = req.getParameter("name");
                String email = req.getParameter("email");
                String address = req.getParameter("address");
                String phone = req.getParameter("phone");
                employess employess = new employess(name,email,phone,address);
                dao.insertEmployess(employess);
                break;
            }
            case "update":{
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                String email = req.getParameter("email");
                String address = req.getParameter("address");
                String phone = req.getParameter("phone");
                employess e = new employess();
                e.setId(id);
                e.setEmail(email);
                e.setName(name);
                e.setAddress(address);
                e.setPhone(phone);
                dao.updateEmployess(e);
                break;
            }
            case "delete":{
                int id = Integer.parseInt(req.getParameter("id"));
                dao.deleteEmployess(id);
                break;
            }
        }
        resp.sendRedirect("index");

    }
}
