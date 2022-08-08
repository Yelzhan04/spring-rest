package com.example.demo.service

import com.example.demo.dto.UserDto

interface UserService {
    fun getAll():List<UserDto>

    fun getById(id: Int):UserDto

    fun create(dto: UserDto):Int

    fun update(id: Int,dto: UserDto)

    fun delete(id: Int)
}