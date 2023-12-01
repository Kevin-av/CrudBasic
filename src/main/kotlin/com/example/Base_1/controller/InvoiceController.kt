package com.example.Base_1.controller

import com.example.Base_1.model.Invoice
import com.example.Base_1.service.InvoiceService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/invoice")
class InvoiceController(private val invoiceService: InvoiceService) {

    @GetMapping
    fun list(): List<Invoice> = invoiceService.list()

    @PostMapping
    fun save(@RequestBody invoice: Invoice): ResponseEntity<Invoice> =
            ResponseEntity.ok(invoiceService.save(invoice))

    @PutMapping
    fun update(@RequestBody invoice: Invoice): ResponseEntity<Invoice> =
            ResponseEntity.ok(invoiceService.update(invoice))

    @PatchMapping
    fun updateName(@RequestBody invoice: Invoice): ResponseEntity<Invoice> =
            ResponseEntity.ok(invoiceService.update(invoice))

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> =
            ResponseEntity.ok(invoiceService.listById(id))

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Unit> {
        invoiceService.delete(id)
        return ResponseEntity.noContent().build()
    }
}
