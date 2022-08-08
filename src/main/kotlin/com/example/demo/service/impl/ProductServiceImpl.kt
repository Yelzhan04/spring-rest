package com.example.demo.service.impl

import com.example.demo.dto.ProductDto
import com.example.demo.entity.ProductEntity
import com.example.demo.repository.ProductRepository
import com.example.demo.service.ProductService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
): ProductService{
    override fun getAll(): List<ProductDto> {
        return productRepository.findAll().map { it.toDto() }
    }

    override fun getById(id: Int): ProductDto {
        return productRepository.findByIdOrNull(id)
            ?.toDto()
            ?:throw RuntimeException("User Not Found")
    }

    override fun create(dto: ProductDto): Int {
        return productRepository.save(dto.toEntity()).id
    }

    override fun update(id: Int, dto: ProductDto) {
        val existingProduct  = productRepository.findByIdOrNull(id)
            ?:throw RuntimeException("Product Not Found")
        existingProduct.title = dto.title
        existingProduct.description = dto.description
        existingProduct.price = dto.price

        productRepository.save(existingProduct)

    }

    override fun delete(id: Int) {
        val existingProduct = productRepository.findByIdOrNull(id)
            ?:throw RuntimeException("User not found")
        productRepository.deleteById(existingProduct.id)
    }

    private fun ProductEntity.toDto():ProductDto =
        ProductDto(
            id = this.id,
            title = this.title,
            description = this.description,
            price = this.price
        )
    private fun ProductDto.toEntity():ProductEntity =
        ProductEntity(
            id = 0,
            title = this.title,
            description = this.description,
            price = this.price
        )

}