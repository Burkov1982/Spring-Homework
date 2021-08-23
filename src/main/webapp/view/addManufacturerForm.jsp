<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form:form method="post" modelAttribute="manufacturer" class="form-signin" action="/manufacturers/addManufacturer">
        Manufacturer name: <form:input type="text" path="name" placeholder="Enter manufacturer name"/> <br/>
        <button type="submit">Update manufacturer</button>
    </form:form>
</body>
</html>