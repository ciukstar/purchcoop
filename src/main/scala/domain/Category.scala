package domain {

  import org.squeryl.KeyedEntity

  class Category(val name: String) extends KeyedEntity[Long] {
    val id: Long = -1
  }
}
