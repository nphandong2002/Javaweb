<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Bordered Table</h2>
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Add</button>
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add Employe</h4>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/home" method="get">
                        <input type="text" id="type" value="add" hidden>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email">
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone</label>
                            <input type="number" class="form-control" id="phone">
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <input type="text" class="form-control" id="address">
                        </div>
                        <button type="submit" class="btn btn-default" >Submit</button>
                    </form>
                </div>

            </div>

        </div>
    </div>
    <p>The .table-bordered class adds borders to a table:</p>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${requestScope.employess.size() > 0}">
                <c:forEach var="item" items="${requestScope.employess}">
                    <td><input type="checkbox" name="checkbox"></td>
                    <td>${item.name}</td>
                    <td>${item.email}</td>
                    <td>${item.phone}</td>
                    <td>${item.adress}</td>
                    <td> <button class="btn btn-primary" onclick="Edit(${item.id})">Edit</button></td>
                    <td><button class="btn btn-primary" onclick="Delete(${item.id})">Delete</button></td>
                </c:forEach>
            </c:if>

        ${requestScope.employess}
        </tbody>
    </table>
</div>
</body>
<script>
    var Delete = (id)=>{
        let text = "Bạn muốn xóa người dùng này ?";
        if (confirm(text) != true) {
            return;
        }
        fetch("/home",{
            method: 'Get',
            mode: 'cors',
            cache: 'no-cache',
            credentials: 'same-origin',
            headers: {
                'Content-Type': 'application/json'
            },
            redirect: 'follow',
            referrerPolicy: 'no-referrer',
            body: JSON.stringify({
                type: "delele",
                id: id
            })
        });
        return window.reload();
    }
</script>
</html>