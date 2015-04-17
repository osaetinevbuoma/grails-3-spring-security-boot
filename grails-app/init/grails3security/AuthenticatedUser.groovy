package grails3security

import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User;

/**
 * Created by oevbuoma on 4/16/15.
 */
class AuthenticatedUser extends User {
    /* Inject the Users object of the Users domain model. It will be used to create the wrapped AuthenticatedUser object */
    private Users users

    /**
     * Creates an AuthenticatedUser object based on the Users domain model and mapped
     * in a Spring security User object
     * @param Users users - The Users domain model
     */
    public AuthenticatedUser(Users users) {
        super(users.username, users.password, AuthorityUtils.createAuthorityList(users.role.toString()))
        this.users = users
    }

    /**
     * Gives us access to the ID of our AuthenticatedUser
     * Spring security User object does not contain this information by default
     * @return Long - The ID of the AuthenticatedUser based on the Users domain model
     */
    public Long getId() {
        return users.id
    }

    /**
     * Gives us access to the first name of our AuthenticatedUser
     * Spring security User object does not contain this information by default
     * @return String - The first name of the AuthenticatedUser based on the Users domain model
     */
    public String getFirstName() {
        return users.firstName
    }

    /**
     * Gives us access to the surname of our AuthenticatedUser
     * Spring security User object does not contain this information by default
     * @return String - The surname of the AuthenticatedUser based on the Users domain model
     */
    public String getSurname() {
        return users.surname
    }

    /**
     * Gives us access to the status of our AuthenticatedUser
     * Spring security User object does not contain this information by default
     * @return boolean - The status of the AuthenticatedUser based on the Users domain model
     */
    public boolean getEnabled() {
        return users.enabled
    }
}
