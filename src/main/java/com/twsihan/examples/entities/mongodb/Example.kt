package com.twsihan.examples.entities.mongodb

import com.twsihan.examples.components.base.BaseEntity
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import javax.persistence.Transient as JavaTransient

@Document(collection = "example")
data class Example(
    @Field(value = "name")
    private val name: String?
) : BaseEntity()
