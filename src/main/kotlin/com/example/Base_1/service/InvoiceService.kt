package com.example.Base_1.service

import com.example.Base_1.model.Invoice
import com.example.Base_1.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class InvoiceService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    fun list ():List<Invoice>{
        return invoiceRepository.findAll()
    }

    fun save(invoice: Invoice): Invoice {
        try{
            return invoiceRepository.save(invoice)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(invoice: Invoice): Invoice{
        try {
            invoiceRepository.findById(invoice.id)
                    ?: throw Exception("ID no existe")

            return invoiceRepository.save(invoice)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(invoice: Invoice): Invoice{
        try{
            val response = invoiceRepository.findById(invoice.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                code=invoice.code //un atributo del modelo
            }
            return invoiceRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Invoice?{invoiceRepository
        return invoiceRepository.findById(id)
    }

    fun delete (id: Long?):Boolean?{
        try{
            val response = invoiceRepository.findById(id)
                    ?: throw Exception("ID no existe")
            invoiceRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}