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
            <p><h1>Enter/Update New Todo </h1></p>
        </div>

        <div class="container">
            <form:form method="post" modelAttribute="todoTask">
                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" path="description" required="required"/>
                    <form:errors path="description" cssClass="text-warning" element="div"/>
                </fieldset>

                <fieldset class="mb-3">
                    <form:label path="targetCompleteDate">Target Complete Date</form:label>
                    <form:input type="text" path="targetCompleteDate" required="required"/>
                    <form:errors path="targetCompleteDate" cssClass="text-warning" element="div"/>
                </fieldset>

                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="done"/>
                <input type="submit" class="btn btn-success">
            </form:form>
        </div>

        <%@include file="common/footer.jspf"%>
        <script type="text/javascript">
            $('#targetCompleteDate').datepicker({
                format: 'yyyy-mm-dd'
            });
        </script>

