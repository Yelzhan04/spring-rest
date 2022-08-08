package com.example.demo.entity

import javax.persistence.*

@Entity
@Table(name = "product")
class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int,
    var title:String,
    var description:String,
    var price: Double
)