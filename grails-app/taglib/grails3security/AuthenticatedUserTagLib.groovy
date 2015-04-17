package grails3security


class AuthenticatedUserTagLib {
    //static defaultEncodeAs = [taglib:'html']
    static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    /* Inject (Dependency Injection) the authService to use. In SpringMVC DI would have had @Autowired on the variable  */
    def authService

    /**
     * Check if the user session is authenticated. If it is authenticated and the user is not an
     * anonymous user, it displays the user's first name and surname with the option to logout
     * Else it show a login link.
     * The tag leverages the "authService" service to get the authentication state and authenticated user
     */
    def isAuthenticated = { attrs, body ->
        def authentication = authService.getAuthentication()

        if (authentication != null) {
            if (authentication.principal.equals("anonymousUser")) {
                out << """<li><a href="/auth/login">Login</a> </li>"""
            } else {
                def authenticatedUser = authService.getAuthenticatedUser()

                out << """
                        <li class="dropdown">
                            <a href class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                               Hello, ${authenticatedUser.firstName} ${authenticatedUser.surname}
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="/auth/logout">Logout</a> </li>
                            </ul>
                        </li>
                    """
            }
        }
    }
}
