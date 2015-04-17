package grails3security

import grails.transaction.Transactional
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Transactional
class AuthService implements UserDetailsService {

    /**
     * UserDetailsService is an interface that has method called loadUserByUsername of type that needs to be implemented
     * Spring security automatically makes a call to the implemented service. With Spring MVC this would have been a long
     * process but with the help of Grails and Groovy, we just find the user by their username
     *
     * Class AuthenticatedUser is just an extension of the Users domain model based on spring security.
     * It is just good practice not to overload the domain class with spring security code. This class is only needed
     * when we want to get an authenticated user
     *
     * @param String username The username of the user to authenticate
     * @return AuthenticatedUser - A new AuthenticatedUser object
     * @throws UsernameNotFoundException
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        def user = Users.findByUsername(username)
        return new AuthenticatedUser(user)
    }

    /**
     * Simply returns the authentication context from the SecurityContextHolder
     * @return Authenticated authentication - The authentication from the SecurityContextHolder
     */
    public Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.context.authentication

        return authentication
    }

    /**
     * Returns the authenticated user from the authentication SecurityContextHolder
     * @return AuthenticatedUser authenticatedUser - The authenticated user
     */
    public AuthenticatedUser getAuthenticatedUser() {
        def authentication = getAuthentication()
        AuthenticatedUser authenticatedUser = (AuthenticatedUser) authentication.principal

        return authenticatedUser
    }
}
