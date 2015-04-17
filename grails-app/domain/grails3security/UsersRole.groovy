package grails3security

class UsersRole {
    Users users
    Role role

    String toString() {
        role.toString()
    }

    static belongsTo = [users: Users]

    static constraints = {
    }

    static UsersRole create(Users users, Role role, boolean flush = false) {
        def instance = new UsersRole(users: users, role: role)
        instance.save(flush: flush, insert: true)
        instance
    }
}
