package com.example.Base_1.controller

import com.example.Base_1.model.Product
import com.example.Base_1.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")   //endpoint
class ProductController {
    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun list ():List <Product>{
        return productService.list()
    }

    @PostMapping
    fun save (@RequestBody product:Product):ResponseEntity<Product>{
        return ResponseEntity(productService.save(product), HttpStatus.OK)
    }

}