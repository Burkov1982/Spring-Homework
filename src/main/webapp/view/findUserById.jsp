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
        <h2> List of Users </h2>
    </caption>
    <thead>
    <tr>
        <th align="left">User ID</th>
        <th align="left">User Firstname</th>
        <th align="left">User Lastname</th>
        <th align="left">User Email</th>
        <th align="left">User Role</th>
        <th align="left">User Status</th>
        <th align="left">User Password</th>
        <th colspan="2" align="center">Actions</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.userRole}</td>
            <td>${user.userStatus}</td>
            <td>${user.password}</td>
            <td align="center">
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="/user/delete?id=${user.id}">
                        <button>Delete</button>
                    </a>
                </security:authorize>
            </td>
            <td align="center">
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="/user/form/update?id=${user.id}">
                        <button>Update</button>
                    </a>
                </security:authorize>
            </td>
        </tr>
    </tbody>
</table>
</body>
</html>