package com.example.Base_1.repository

import com.example.Base_1.model.Client
import com.example.Base_1.model.Detail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository : JpaRepository<Detail, Long?> {
    fun findById (id: Long?): Detail?
}

