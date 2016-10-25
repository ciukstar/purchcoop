package domain {

  class PurchasingCoop(
    val id: Long,
    val product: Product,
    val organizer: User
  ) {

    def this(product: Product, organizer: User) = this(-1, product, organizer)
  }
}
