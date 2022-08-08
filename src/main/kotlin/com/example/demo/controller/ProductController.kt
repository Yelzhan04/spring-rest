package com.example.demo.controller

import com.example.demo.dto.ProductDto
import com.example.demo.dto.UserDto
import com.example.demo.service.ProductService
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController(
    private val productService: ProductService
){
    @GetMapping
    fun getAll():List<ProductDto> = productService.getAll()


    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ProductDto {
        return productService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody dto: ProductDto): Int {
        return productService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: ProductDto) {
        return productService.update(id,dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        productService.delete(id)
    }

}