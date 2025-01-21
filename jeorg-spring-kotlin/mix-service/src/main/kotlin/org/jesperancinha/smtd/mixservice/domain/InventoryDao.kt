package org.jesperancinha.smtd.mixservice.domain


class InventoryService {
    var url: String? = null
    var timeout: Long? = null

    fun performOperation() {
        println("Connecting to $url with a timeout of $timeout ms")
    }

    override fun toString(): String {
        return "InventoryService(url='$url', timeout=$timeout)"
    }
}
