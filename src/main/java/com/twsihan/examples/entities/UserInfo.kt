package com.twsihan.examples.entities

import com.twsihan.examples.components.base.BaseEntity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "user_info")
data class UserInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = -1,

    val username: String? = "",

    val password: String? = "",

    val usertype: String? = "",

    val enabled: Int? = 0,

    val qq: String? = "",

    val email: String? = "",

    val tel: String? = ""
) : BaseEntity()
