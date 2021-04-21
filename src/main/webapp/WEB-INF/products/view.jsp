<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <title>Product Page</title>
    </head>

    <body>
        <div class="Container">
            <div class="row mt-4">
                <div class="col-3">
                </div>
                <div class="col-4">
                    <h1>Name:</h1>
                </div>
                <div class="col-5">
                    <h1>
                        <c:out value="${product.name}" />
                    </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-3">
                </div>
                <div class="col-4">
                    <h1>Description:</h1>
                </div>
                <div class="col-5">
                    <h1>
                        <c:out value="${product.description}" />
                    </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-3">
                </div>
                <div class="col-4">
                    <h1>Price:</h1>
                </div>
                <div class="col-5">
                    <h1>
                        <c:out value="${product.price}" />
                    </h1>
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-4">
                </div>
                <div class="col-4">
                    <h1>Categories</h1>
                    <c:forEach items="${product.categories}" var="a">
                        <h3>
                            <c:out value="${a.name}" />
                        </h3>
                    </c:forEach>
                </div>
                <div class="col-4">
                    <form:form action="/productAddCategory/${product.id}" method="post" modelAttribute="product">
                        <div class="form-group mb-3">
                            <form:label path="categories" class="form-label">Categories:</form:label>
                            <form:errors path="categories" class="form-text"></form:errors>
                            <form:select path="categories" class="form-control">
                                <c:forEach items="${categories}" var="d">
                                    <form:option value="${d.id}">${d.name}</form:option>
                                </c:forEach>
                            </form:select>
                            <button type="submit" class="btn btn-primary">Add</button>
                        </form:form>
                        </div>
                </div>
            </div>
        </div>
    </body>

    </html>