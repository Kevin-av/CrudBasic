package com.example.Base_1.mapper

import com.example.Base_1.dto.ProductDto
import com.example.Base_1.model.Product
import com.example.Base_1.repository.ProductRepository

class ProductMapper(private val productRepository: ProductRepository) {

    fun mapToDto(product: Product): ProductDto {
        return ProductDto(
                product.id,
                "${product.description} ${product.brand}"
        )
    }

    fun listDto(): List<ProductDto> {
        val productList = productRepository.findAll()

        return productList.filterNotNull().map { mapToDto(it) }
    }
}
