package com.example.Base_1.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

@Entity
@Table(name = "invoice")
class Invoice(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false)
        var id: Long? = null,

        @NotBlank(message = "Campo Obligatorio")
        var code: String? = null,

        @NotBlank(message = "Campo Obligatorio")
        var create_at: LocalDateTime? = null, // Assuming it's a date or datetime field

        @NotBlank(message = "Campo Obligatorio")
        var total: Double? = null, // Assuming it's a numeric field

        @NotBlank(message = "Campo Obligatorio")
        var clientID: String? = null
)
