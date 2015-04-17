package grails3security

class AuthController {

    /**
     * Display the login page.
     * If a parameter "error" is sent through the URL, then it displays a authentication error message
     * If a parameter "logout" is sent through the URL, it indicated a user is successfully logged out
     * @return
     */
    def login() {
        if (request.queryString == "error") {
            flash.error = "Wrong authentication credentials"
        }

        if (request.queryString == "logout") {
            flash.logout = "Successfully logged out"
        }

        render view: "login"
    }
}
