<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Java Developer 8</title>
        <style>
            <%@include file="/view/css/style.css" %>
        </style>
    </head>
    <body>
        <c:import url="/view/navigation.jsp"/>
        <table cellpadding="5">
            <caption>
                <h2>List of Products</h2>
            </caption>
            <thead>
                <tr>
                    <th align="left">Product name</th>
                    <th align="left">Manufacturer name</th>
                    <th colspan="2" align="center">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.name}</td>
                        <td>${manufacturer.name}</td>
                        <td align="center">
                            <a href="/products/findProductById?id=${product.id}">
                                <button>Details</button>
                            </a>
                        </td>
                        <td align="center">
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="/products/form/update?id=${product.id}">
                                    <button>Update</button>
                                </a>
                            </security:authorize>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>