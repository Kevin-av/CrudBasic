package com.example.Base_1.repository

import com.example.Base_1.model.Invoice
import com.example.Base_1.model.Product
import jakarta.persistence.NamedNativeQuery
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long?> {
    fun findById (id: Long?): Product?
}