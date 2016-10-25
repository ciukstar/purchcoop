package domain {

  class Dispenser(val id: Long, val address: String, val map: Array[Byte]) {

    def this(address: String, map: Array[Byte]) = this(-1, address, map)
  }
}
