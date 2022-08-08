package com.example.demo.controller

import com.example.demo.dto.UserDto
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
) {

    @GetMapping
    fun getAll(): List<UserDto> = userService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int):UserDto{
        return userService.getById(id)
    }

    @PostMapping
    fun create(@RequestBody dto: UserDto): Int {
        return userService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: UserDto) {
        return userService.update(id,dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        userService.delete(id)
    }
}