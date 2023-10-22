package com.example.Base_1.service

import com.example.Base_1.model.Product
import com.example.Base_1.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository

    fun list ():List<Product>{
        return productRepository.findAll()
    }

    fun save(product: Product): Product {
        try{
            return productRepository.save(product)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(product: Product): Product{
        try {
            productRepository.findById(product.id)
                    ?: throw Exception("ID no existe")

            return productRepository.save(product)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(product: Product): Product{
        try{
            val response = productRepository.findById(product.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                category=product.category //un atributo del modelo
            }
            return productRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Product?{
        return productRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = productRepository.findById(id)
                    ?: throw Exception("ID no existe")
            productRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}