<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">    
    <title>New Category</title>
</head>
<body>
    <div class="container mx-auto mt-5" style="width: 500px;">
        <h1>New Category</h1>
        <form:form action="/categories" method="post" modelAttribute="category">
            <div class="form-group mb-3">
                <form:label path="name" class="form-label">Name:</form:label>
                <form:errors path="name" class="form-text"></form:errors>
                <form:input path="name" class="form-control"></form:input>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
        </form:form>
    </div>
</body>
</html>