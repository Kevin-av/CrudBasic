package com.example.Base_1.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "client")
class Client(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false)
        var id: Long? = null,

        @NotBlank(message = "Campo Obligatorio")
        @Column(length = 255, nullable = false) // Adjust the length accordingly
        var fullname: String? = null,

        @NotBlank(message = "Campo Obligatorio")
        @Column(length = 255, nullable = false) // Adjust the length accordingly
        var address: String? = null
)
