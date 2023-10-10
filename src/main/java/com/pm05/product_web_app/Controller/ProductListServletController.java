package com.pm05.product_web_app.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.pm05.product_web_app.model.db.DBCrud;
import com.pm05.product_web_app.model.db.MySQLConnector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ProductList")
public class ProductListServletController<Product> extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        Connection conn = null;
        List<com.pm05.product_web_app.model.Product> productlist = null;
        try {
            conn = MySQLConnector.getMySQLConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        productlist = DBCrud.getAllProduct(conn);

        MySQLConnector.Closeconnection(conn);

        req.setAttribute("PRODUCTLIST", productlist);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ProductList.jsp");
        dispatcher.forward(req, resp);
        };

     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
    }

}
