package grails3security

class UsersController {
    /* Inject authService */
    def authService

    /**
     * Display the index page with the list of registered users
     * Accounts with authority ROLE_ADMIN will see the username and hashed passwords of the users
     * Accounts with authority ROLE_USER will only see the first name and surname of the users
     * See Bootstrap.groovy for login accounts of all the users
     * @return
     */
    def index() {
        def authenticatedUser = authService.getAuthenticatedUser()
        render view: "/index", model: [users: Users.list(), authorities: authenticatedUser.authorities]
    }
}
