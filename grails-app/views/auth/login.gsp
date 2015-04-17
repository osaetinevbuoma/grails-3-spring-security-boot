<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>
<div class="row">
    <div class="col-lg-5 col-lg-offset-3">
        <h1>Login</h1> <hr />

        <g:if test="${flash.error}">
            <div class="alert alert-danger">${flash.error}</div>
        </g:if>

        <g:if test="${flash.logout}">
            <div class="alert alert-success">${flash.logout}</div>
        </g:if>

        <g:form method="post" url="/auth/login">
            <div class="form-group">
                <label for="username">Username</label>
                <g:textField name="username" class="form-control" />
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <g:passwordField name="password" class="form-control" />
            </div>
            <g:submitButton name="login" value="Login" class="btn btn-primary" />
        </g:form>
    </div>
</div>
</body>
</html>
