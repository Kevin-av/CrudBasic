package com.example.Base_1.controller

import com.example.Base_1.model.Detail
import com.example.Base_1.service.DetailService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/detail")
class DetailController(private val detailService: DetailService) {

    @GetMapping
    fun list(): List<Detail> = detailService.list()

    @PostMapping
    fun save(@RequestBody detail: Detail): ResponseEntity<Detail> =
            ResponseEntity.ok(detailService.save(detail))

    @PutMapping
    fun update(@RequestBody detail: Detail): ResponseEntity<Detail> =
            ResponseEntity.ok(detailService.update(detail))

    @PatchMapping
    fun updateName(@RequestBody detail: Detail): ResponseEntity<Detail> =
            ResponseEntity.ok(detailService.update(detail))

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> =
            ResponseEntity.ok(detailService.listById(id))

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Unit> {
        detailService.delete(id)
        return ResponseEntity.noContent().build()
    }
}
