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
class Detail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Campo Obligatorio")
    var quantity: String? =null
    @NotBlank(message="Campo Obligatorio")
    var price: String? = null
    @NotBlank(message="Campo Obligatorio")
    var invoiceId: String? = null
    @NotBlank(message="Campo Obligatorio")
    var productId: String? = null
}