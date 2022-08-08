package com.example.demo.entity

import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    var firstName: String ="",
    var lastName: String = "",
    var address:String ="",
    var city:String=""

)