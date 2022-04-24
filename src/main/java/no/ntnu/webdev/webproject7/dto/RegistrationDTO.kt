package no.ntnu.webdev.webproject7.dto

import no.ntnu.webdev.webproject7.utilities.objectsNotNull
import no.ntnu.webdev.webproject7.utilities.validateEmail

data class RegistrationDTO(
    val username: String,
    val email: String,
    val password: String
) : DTO {

    override fun validate(): Boolean {
        val fields = listOf(this.username, this.email, this.password);
        return objectsNotNull(fields) && fields.none { s: String -> s.isBlank() } && validateEmail(email);
    }
};
