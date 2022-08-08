package com.example.demo.dto

data class UserDto(
    val id: Int?= null,
    val firstName: String,
    val lastName: String,
    val address:String,
    val city:String
)
