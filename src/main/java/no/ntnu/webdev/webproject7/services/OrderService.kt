package no.ntnu.webdev.webproject7.services

import no.ntnu.webdev.webproject7.models.Order
import no.ntnu.webdev.webproject7.models.OrderId
import no.ntnu.webdev.webproject7.models.UserEntityId
import no.ntnu.webdev.webproject7.repositories.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService(@Autowired orderRepository: OrderRepository) : CrudService<Order, OrderId>(orderRepository) {

    fun getUsersOrders(id: UserEntityId): List<Order> {
        return this.all().stream()
            .filter { it.user!!.id == id }
            .toList();
    }
}
