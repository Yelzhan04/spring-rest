package com.example.demo.service.impl

import com.example.demo.dto.UserDto
import com.example.demo.entity.UserEntity
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun getAll(): List<UserDto> {
        return userRepository.findAll().map{it.toDto()}
    }

    override fun getById(id: Int): UserDto {
        return userRepository.findByIdOrNull(id)
            ?.toDto()
            ?:throw RuntimeException("User Not Found")
    }

    override fun create(dto: UserDto): Int {
        return userRepository.save(dto.toEntity()).id

    }

    override fun update(id: Int, dto: UserDto) {
        val existingUser = userRepository.findByIdOrNull(id)
            ?:throw RuntimeException("User not found")
        existingUser.firstName = dto.firstName
        existingUser.lastName = dto.lastName
        existingUser.address = dto.address
        existingUser.city = dto.city

        userRepository.save(existingUser)
    }

    override fun delete(id: Int) {
        val existingUser = userRepository.findByIdOrNull(id)
            ?:throw RuntimeException("User not found")
        userRepository.deleteById(existingUser.id)

    }

    private fun UserEntity.toDto():UserDto =
        UserDto(
            id = this.id,
            firstName = this.firstName,
            lastName = this.lastName,
            address = this.address,
            city = this.city

        )
    private fun UserDto.toEntity():UserEntity =
        UserEntity(
            id = 0,
            firstName = this.firstName,
            lastName = this.lastName,
            address = this.address,
            city = this.city
        )
}