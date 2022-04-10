package me.oblomov

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class NativeApplication

fun main(args: Array<String>) {
    runApplication<NativeApplication>(*args)
}

@Controller
@ResponseBody
class CustomerController( private val repo: CustomerRepository) {
    @GetMapping("/customers")
    fun customers() = this.repo.findAll()
}

data class Customer (@Id val id: Int, val name: String)

interface CustomerRepository : ReactiveCrudRepository<Customer, Int>