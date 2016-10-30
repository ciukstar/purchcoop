package edu.ciukstar.cooper.domain {

  class Purchase(
    val id: Long,
    val product: Product,
    val organizer: User
  ) {

    def this(product: Product, organizer: User) = this(-1, product, organizer)
  }
}
