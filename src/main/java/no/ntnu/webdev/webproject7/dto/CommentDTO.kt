package no.ntnu.webdev.webproject7.dto

import no.ntnu.webdev.webproject7.utilities.objectsNotNull

data class CommentDTO(
    val text: String
) : DTO {

    override fun validate(): Boolean {
        return objectsNotNull(this.text) && this.text.length <= 1000;
    }
}
