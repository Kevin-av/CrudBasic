package com.example.Base_1.controller

import com.example.Base_1.model.Client
import com.example.Base_1.service.ClientService
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/client")
class ClientController(private val clientService: ClientService) {

    @GetMapping
    fun list (model: Client, pageable: Pageable):ResponseEntity<*>{
        val response= clientService.list(pageable, model)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody client: Client): ResponseEntity<Client> =
            ResponseEntity.ok(clientService.save(client))

    @PutMapping
    fun update(@RequestBody client: Client): ResponseEntity<Client> =
            ResponseEntity.ok(clientService.update(client))

    @PatchMapping
    fun updateName(@RequestBody client: Client): ResponseEntity<Client> =
            ResponseEntity.ok(clientService.update(client))

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> =
            ResponseEntity.ok(clientService.listById(id))

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Unit> {
        clientService.delete(id)
        return ResponseEntity.noContent().build()
    }
}
