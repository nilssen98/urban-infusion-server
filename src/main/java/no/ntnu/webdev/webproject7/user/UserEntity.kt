package no.ntnu.webdev.webproject7.user

import no.ntnu.webdev.webproject7.crud.CrudModel
import javax.persistence.Entity
import javax.persistence.Id

typealias UserEntityId = String;

@Entity
class UserEntity : CrudModel<UserEntityId> {
    @Id
    override var id: UserEntityId? = null
    var admin: Boolean? = null
    var email: String? = null
    var password: String? = null

    constructor(id: UserEntityId?, admin: Boolean?, email: String?, password: String?) {
        this.id = id
        this.admin = admin
        this.email = email
        this.password = password
    }

    protected constructor()
}
