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
        <h2> Manufacturer detail </h2>
    </caption>
    <thead>
    <tr>
        <th align="left">Manufacturer name</th>
        <th align="left">Product name</th>
        <th colspan="2" align="center">Actions</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${manufacturer.name}</td>
            <td>
                <ul>
                    <c:forEach var="product" items="${manufacturer.products}">
                        <li>${product.name}</li>
                    </c:forEach>
                </ul>
            </td>
            <td align="center">
                <a href="/manufacturers/form/update?id=${manufacturer.id}">
                    <button>Update</button>
                </a>
            </td>
            <td align="center">
                <a href="/manufacturers/delete?id=${manufacturer.id}">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </tbody>
</table>
</body>
</html>