<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            ProductList Page
        </title>
    </head>
    <body>
        <!-- header -->
        <jsp:include page = "Header.jsp"></jsp:include>
        <!-- menu -->
        <jsp:include page = "Menu.jsp"></jsp:include>
        <h3>ProductList PAGE!</h3>

        <table border="1" cellpadding="5" cellspacing="1">
            <!-- title -->
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <!-- body -->
            <c:forEach items = "${PRODUCTLIST}" var = "product">
                <tr>
                    <td>${product.code}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td><a href="editProduct?code=${product.code}">Edit</a></td>
                    <td><a href="deleteProduct?code=${product.code}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="CreateProduct">createproduct</a>
        <!-- footer -->
        <jsp:include page = "Footer.jsp"></jsp:include>
    


    </body>
</html>