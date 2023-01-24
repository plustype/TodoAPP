<%@include file="common/header.jspf"%>

<style>
    .container{
        width: 600px;
        display: block;
        margin:0 100px;
    }
    .center{
        text-align: center;
    }
    label {
        display: inline-block;
        width: 180px;
        text-align: left;
    }
    input,textarea{
        vertical-align: top;
    }
</style>

<body>
        <%@ include file="common/navigation.jspf"%>
        <div class="container">
            <h1>Welcome, ${name}</h1>
            <h3><a href="todo-list">Check your todo tasks</a></h3>
        </div>

    </body>
</html>

