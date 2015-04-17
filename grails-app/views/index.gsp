<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Welcome to Grails</title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-5 col-lg-offset-3">
                <h1>List of Users</h1> <hr />

                <table class="table table-responsive table-hover table-striped">
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Surname</th>
                        <g:each in="${authorities}" var="authority">
                        <g:if test="${authority.toString().equals("ROLE_ADMIN")}">
                            <th>Username</th>
                            <th>Password</th>
                        </g:if>
                        </g:each>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${users}" var="user">
                        <tr>
                            <td>${user.firstName}</td>
                            <td>${user.surname}</td>
                        <g:each in="${authorities}" var="authority">
                        <g:if test="${authority.toString().equals("ROLE_ADMIN")}">
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                        </g:if>
                        </g:each>
                            <td>
                                <g:if test="${user.enabled == true}">
                                    Enabled
                                </g:if>
                                <g:else>
                                    Disabled
                                </g:else>
                            </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
