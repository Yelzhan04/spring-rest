package com.example.demo.repository

import com.example.demo.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository:CrudRepository<UserEntity,Int> {
}