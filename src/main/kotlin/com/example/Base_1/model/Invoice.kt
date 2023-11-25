package com.example.Base_1.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "invoice")
class Invoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Campo Obligatorio")
    var code: String? =null
    @NotBlank(message="Campo Obligatorio")
    var create_at: String? = null
    @NotBlank(message="Campo Obligatorio")
    var total: String? = null
    @NotBlank(message="Campo Obligatorio")
    var clientID: String? = null
}