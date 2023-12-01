package com.example.Base_1.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "product")
class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false)
        var id: Long? = null,

        @NotBlank(message = "Campo Obligatorio")
        var description: String? = null,

        @NotBlank(message = "Campo Obligatorio")
        var brand: String? = null,

        @NotBlank(message = "Campo Obligatorio")
        var price: Double? = null, // Assuming it's a numeric field

        @NotBlank(message = "Campo Obligatorio")
        var stock: Int? = null // Assuming it's a numeric field
)
