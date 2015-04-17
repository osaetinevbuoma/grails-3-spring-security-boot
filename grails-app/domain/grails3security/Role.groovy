package grails3security

class Role {
    String authority

    String toString() {
        "$authority"
    }

    static hasMany = [users: Users]
//    static hasMany = [usersRole: UsersRole]

    static constraints = {
        authority nullable: false
    }
}
