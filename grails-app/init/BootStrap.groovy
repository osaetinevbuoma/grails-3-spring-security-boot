import grails3security.Role
import grails3security.Users
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

class BootStrap {

    def init = { servletContext ->
        // Roles
        def role1 = new Role(authority: "ROLE_ADMIN").save(flush: true)
        def role2 = new Role(authority: "ROLE_USER").save(flush: true)

        // Encode Passwords
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder()
        String doe = passwordEncoder.encode("doe")
        String charlton = passwordEncoder.encode("charlton")

        // Users
        def user1 = new Users(firstName: "John", surname: "Doe", username: "j.doe", password: doe, role: role1).save(flush: true)
        def user2 = new Users(firstName: "Jane", surname: "Doe", username: "jane.doe", password: doe, role: role2).save(flush: true)
        def user3 = new Users(firstName: "Jonathan", surname: "Charlton", username: "jonathan.charlton", password: charlton,
                role: role2).save(flush: true)
        def user4 = new Users(firstName: "Sarah", surname: "Charlton", username: "sarah.charlton", password: charlton,
                role: role2).save(flush: true)
    }
    def destroy = {
    }
}
