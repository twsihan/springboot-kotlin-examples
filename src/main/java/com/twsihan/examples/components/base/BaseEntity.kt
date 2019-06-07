package com.twsihan.examples.components.base

import lombok.Getter
import lombok.Setter
import java.io.Serializable

open class BaseEntity : Serializable
{
    companion object {
        private const val serialVersionUID = 1L
    }

    @Setter
    @Getter
    @javax.persistence.Transient
    @org.springframework.data.annotation.Transient
    open val page: Int? = null

    @Setter
    @Getter
    @javax.persistence.Transient
    @org.springframework.data.annotation.Transient
    open val rows: Int? = null
}
