package com.example.Base_1.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "detail")
class Detail(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false)
        var id: Long? = null,

        @NotBlank(message = "Campo Obligatorio")
        var quantity: Int? = null, // Assuming it's a numeric field

        @NotBlank(message = "Campo Obligatorio")
        var price: Double? = null, // Assuming it's a numeric field

        @NotBlank(message = "Campo Obligatorio")
        var invoiceId: String? = null,

        @NotBlank(message = "Campo Obligatorio")
        var productId: String? = null
)
