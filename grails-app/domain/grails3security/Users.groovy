package grails3security

class Users {
    String firstName
    String surname
    String username
    String password
    boolean enabled = true
    Role role

//    static hasMany = [usersRole: UsersRole]

    static constraints = {
        firstName nullable: false
        surname nullable: false
        username nullable: false
        password nullable: false
        role nullable: false
    }
}
