package com.example.Base_1.controller

import com.example.Base_1.model.Product
import com.example.Base_1.service.ProductService
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/product")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun list (model: Product, pageable: Pageable):ResponseEntity<*>{
        val response= productService.list(pageable, model)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody product: Product): ResponseEntity<Product> =
            ResponseEntity.ok(productService.save(product))

    @PutMapping
    fun update(@RequestBody product: Product): ResponseEntity<Product> =
            ResponseEntity.ok(productService.update(product))

    @PatchMapping
    fun updateName(@RequestBody product: Product): ResponseEntity<Product> =
            ResponseEntity.ok(productService.update(product))

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> =
            ResponseEntity.ok(productService.listById(id))

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Unit> {
        productService.delete(id)
        return ResponseEntity.noContent().build()
    }
}
