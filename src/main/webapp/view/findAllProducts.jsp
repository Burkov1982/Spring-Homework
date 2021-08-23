<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                        <td>${product.price}</td>
                        <td align="center">
                            <a href="/products/findProductById?id=${product.id}">
                                <button>Details</button>
                            </a>
                        </td>
                        <td align="center">
                            <a href="/products/form/update?id=${product.id}">
                                <button>Update</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>