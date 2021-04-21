<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">    
    <title>New Product</title>
</head>
<body>
    <div class="container mx-auto mt-5" style="width: 500px;">
        <h1>New Product</h1>
        <form:form action="/products" method="post" modelAttribute="product">
            <div class="form-group mb-3">
                <form:label path="name" class="form-label">Name:</form:label>
                <form:errors path="name" class="form-text"></form:errors>
                <form:input path="name" class="form-control"></form:input>
            </div>
            <div class="form-group mb-3">
                <form:label path="description" class="form-label">Description:</form:label>
                <form:errors path="description" class="form-text"></form:errors>
                <form:input path="description" class="form-control rows-4"></form:input>
            </div>
            <div class="form-group mb-3">
                <form:label path="price" class="form-label">Price:</form:label>
                <form:errors path="price" class="form-text"></form:errors>
                <form:input path="price" class="form-control" type="number"></form:input>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
        </form:form>
    </div>
</body>
</html>