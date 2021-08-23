<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            <%@include file="/view/css/style.css" %>
        </style>
    </head>

    <body>
        <div class="navbar">
          <a href="/">Home</a>

          <div class="dropdown">
            <button class="dropbtn">Manufacturer
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}/manufacturers/findAllManufacturers">Show Manufacturers</a>
                <a href="${pageContext.request.contextPath}/manufacturers/form/add">Create Manufacturer</a>
            </div>
          </div>

          <div class="dropdown">
            <button class="dropbtn">Product
                <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
                <a href="${pageContext.request.contextPath}/products/findAllProducts">Show Products</a>
                <a href="${pageContext.request.contextPath}/products/form/add">Create Product</a>
            </div>
          </div>
        </div>
    </body>
</html>
