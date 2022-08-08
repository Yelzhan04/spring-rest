package com.example.demo.repository

import com.example.demo.entity.ProductEntity
import org.springframework.data.repository.CrudRepository

interface ProductRepository:CrudRepository<ProductEntity,Int>{
}