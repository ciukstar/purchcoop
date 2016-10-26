package domain {

  import java.time._

  class Order (
    val id: Long,
    val customerId: Long,
    val purchaseId: Long,
    val quantity: Int,
    val orderDate: LocalDateTime
  ) {

    def this(customer: User, purchase: Purchase, quantity: Int) =
      this(-1, customer.id, purchase.id, quantity, LocalDateTime.now())

    def this(customer: User, purchase: Purchase, quantity: Int, orderDate: LocalDateTime) =
      this(-1, customer.id, purchase.id, quantity, orderDate)
  }
}
