package com.pm05.product_web_app.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.pm05.product_web_app.model.Product;
import com.pm05.product_web_app.model.db.DBCrud;
import com.pm05.product_web_app.model.db.MySQLConnector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/editProduct")
public class editProductServletController extends HttpServlet {

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

        Product product = DBCrud.findProductByCode(conn, code);
        MySQLConnector.Closeconnection(conn);
        req.setAttribute("product",product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/EditProductView.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String pricestr = req.getParameter("price");

        double price = Double.parseDouble(pricestr);
        Connection conn = null;

        Product product = new Product(code, name, price);
        try {
            conn = MySQLConnector.getMySQLConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBCrud.updateProduct(conn, product);
        MySQLConnector.Closeconnection(conn);
        resp.sendRedirect(req.getContextPath()+"/ProductList");
    }
    
}
