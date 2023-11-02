package com.example.Base_1.repository

import com.example.Base_1.model.Ventas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VentasRepository : JpaRepository<Ventas, Long?> {
    fun findById (id: Long?): Ventas?
}