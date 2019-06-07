package com.twsihan.examples.entities

import com.twsihan.examples.components.base.BaseEntity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "country")
data class Country(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = -1,

    val countryname: String? = "",

    val countrycode: String? = ""
) : BaseEntity()
