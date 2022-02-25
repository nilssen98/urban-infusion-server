package no.ntnu.webdev.webproject7.comment

import no.ntnu.webdev.webproject7.crud.CrudModel
import no.ntnu.webdev.webproject7.product.Product
import no.ntnu.webdev.webproject7.user.UserEntity
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Comment : CrudModel<String> {
    @Id
    override var id: String? = null

    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: Product? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: UserEntity? = null
    var text: String? = null
    var date: LocalDate? = null

    constructor(id: String?, product: Product?, user: UserEntity?, text: String?, date: LocalDate?) {
        this.id = id
        this.product = product
        this.user = user
        this.text = text
        this.date = date
    }

    protected constructor()
}