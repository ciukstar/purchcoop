package edu.ciukstar.cooper.domain {

  class Dispenser(val id: Long, val address: String, val map: Option[Array[Byte]]) {

    def this(address: String) = this(-1, address, None)
    def this(address: String, map: Option[Array[Byte]]) = this(-1, address, map)
  }
}
