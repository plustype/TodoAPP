<%@include file="common/header.jspf"%>

<body>
        <%@ include file="common/navigation.jspf"%>
        <div class="container">
            <p><h1>Your Todo Tasks</h1></p>

        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Complete?</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${todoTasks}" var="todoTask">
                    <tr>
                        <td>${todoTask.id}</td>
                        <td>${todoTask.description}</td>
                        <td>${todoTask.targetCompleteDate}</td>
                        <td>${todoTask.done}</td>
                        <td><a href="update-todo?id=${todoTask.id}" class="btn btn-success">UPDATE</a> </td>
                        <td><a href="delete-todo?id=${todoTask.id}" class="btn btn-warning">DELETE</a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
    <%--        add JavaScript file--%>
        <%@include file="common/footer.jspf"%>

