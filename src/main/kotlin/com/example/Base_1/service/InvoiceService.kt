package com.example.Base_1.service

import com.example.Base_1.model.Invoice
import com.example.Base_1.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class InvoiceService @Autowired constructor(private val invoiceRepository: InvoiceRepository) {

    fun list(): List<Invoice> {
        return invoiceRepository.findAll()
    }

    fun save(invoice: Invoice): Invoice {
        try {
            validateInvoice(invoice)
            return invoiceRepository.save(invoice)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun update(invoice: Invoice): Invoice {
        try {
            invoiceRepository.findById(invoice.id)
                    ?: throw Exception("ID no existe")

            return invoiceRepository.save(invoice)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(invoice: Invoice): Invoice {
        try {
            val response = invoiceRepository.findById(invoice.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                code = invoice.code // un atributo del modelo
            }
            return invoiceRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById(id: Long?): Invoice? {
        return invoiceRepository.findById(id)
    }

    private fun validateInvoice(invoice: Invoice) {
        with(invoice) {
            code?.takeIf { it.isNotBlank() }
                    ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "El código de la factura no debe ser nulo o vacío")
            create_at?.takeIf { it.isNotBlank() }
                    ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de creación no debe ser nulo o vacía")
            total?.takeIf { it >= 0 }
                    ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "El total de la factura no debe ser negativo")
        }
    }

    fun filterTotal(value: Double?): List<Invoice>? {
        return invoiceRepository.filterTotal(value)
    }

    fun delete(id: Long?): Boolean? {
        try {
            val response = invoiceRepository.findById(id)
                    ?: throw Exception("ID no existe")
            invoiceRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}
