package com.example.Base_1.controller

import com.example.Base_1.model.Invoice
import com.example.Base_1.model.JSendResponse
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

    @PatchMapping("/updateName") // Corrección en el nombre del método
    fun updateName(@RequestBody invoice: Invoice): ResponseEntity<Invoice> =
            ResponseEntity.ok(invoiceService.updateName(invoice))

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): ResponseEntity<*> {
        val invoice = invoiceService.listById(id)
        return if (invoice != null) {
            ResponseEntity.ok(invoice)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(JSendResponse(status = "fail", data = null, message = "Invoice not found"))
        }
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        invoiceService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/filter-total/{value}")
    fun listTotals(@PathVariable("value") value: Double?): ResponseEntity<*> {
        return ResponseEntity(invoiceService.filterTotal(value), HttpStatus.OK)
    }
}
