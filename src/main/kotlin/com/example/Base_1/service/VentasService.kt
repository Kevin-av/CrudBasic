package com.example.Base_1.service

import com.example.Base_1.model.Product
import com.example.Base_1.model.Ventas
import com.example.Base_1.repository.ProductRepository
import com.example.Base_1.repository.VentasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class VentasService {
    lateinit var ventasRepository: VentasRepository

    fun list ():List<Ventas>{
        return ventasRepository.findAll()
    }

    fun save(product: Ventas): Ventas {
        try {
            val id = product.description?.trim() ?: ""
            if (id.isEmpty()) {
                throw Exception("El campo 'description' no debe estar vacío")
            }
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message, ex)
        }

        try {
            return ventasRepository.save(product)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun update(product: Ventas): Ventas {
        try {
            ventasRepository.findById(product.id)
                    ?: throw Exception("ID no existe")

            return ventasRepository.save(product)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(ventas: Ventas): Ventas {
        try{
            val response = ventasRepository.findById(ventas.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                category=ventas.category
            }
            return ventasRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?): Ventas?{
        return ventasRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = ventasRepository.findById(id)
                    ?: throw Exception("ID no existe")
            ventasRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}