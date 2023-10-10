package com.pm05.product_web_app.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.pm05.product_web_app.model.db.DBCrud;
import com.pm05.product_web_app.model.db.MySQLConnector;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/deleteProduct")
public class deleteProductServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        Connection conn = null;
        try {
            conn = MySQLConnector.getMySQLConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBCrud.deleteProduct(conn, code);
        MySQLConnector.Closeconnection(conn);
        resp.sendRedirect(req.getContextPath()+"/ProductList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    
}
