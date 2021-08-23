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
                <h2>Product</h2>
            </caption>
            <thead>
                <tr>
                    <th align="left">Product name</th>
                    <th align="left">Product price</th>
                    <th align="left">Manufacturer name</th>
                    <th colspan="2" align="center">Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${manufacturer.name}</td>
                    <td align="center">
                        <a href="/products/form/update?id=${product.id}">
                            <button>Update</button>
                        </a>
                    </td>
                    <td align="center">
                        <a href="/products/delete?id=${product.id}">
                            <button>Delete</button>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>