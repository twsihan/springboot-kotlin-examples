package com.twsihan.examples.entities

import com.twsihan.examples.components.base.BaseEntity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "city")
data class City(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = -1,

    val name: String? = "",

    val state: String? = ""
) : BaseEntity()
