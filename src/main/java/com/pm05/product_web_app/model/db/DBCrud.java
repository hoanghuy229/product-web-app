package com.pm05.product_web_app.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pm05.product_web_app.model.Product;

public class DBCrud {
    public static List<Product> getAllProduct(Connection conn){

        List<Product> productlist = null;
        String sql = "SELECT * from product";
        PreparedStatement ps = null;
        ResultSet rs = null;
        productlist = new ArrayList<>();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Product product = new Product(code, name, price);
                productlist.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productlist;
    }
    public static void insertProduct(Connection conn,Product product){
        String sqlString = "insert into product (code,name,price) values (?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sqlString);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Product findProductByCode(Connection conn,String code){
       Product product = null;
       String sql = "SELECT code, name, price FROM product where code = ?";

    try {
       PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,code);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            String name = rs.getString("name");
            double price = rs.getDouble("price");
            product = new Product(code, name, price);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

       
        return product;

    }
    public static void updateProduct(Connection conn,Product product){
        String sql = "update product set name = ?, price = ?      where code = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setDouble(2,product.getPrice());
            ps.setString(3,product.getCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void deleteProduct(Connection conn,String code){
        String sql = "delete FROM  product where code =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,code);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
