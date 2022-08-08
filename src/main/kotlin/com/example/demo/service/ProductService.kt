package com.example.demo.service

import com.example.demo.dto.ProductDto
import com.example.demo.dto.UserDto

interface ProductService {
    fun getAll():List<ProductDto>

    fun getById(id: Int): ProductDto

    fun create(dto: ProductDto):Int

    fun update(id: Int,dto: ProductDto)

    fun delete(id: Int)
}