package com.twsihan.examples

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application
{
    private val logger: Logger = LogManager.getLogger(Application::class.java)

    init {
        logger.info("Kotlin Spring Boot !!!")
    }
}

fun main(args: Array<String>)
{
    runApplication<Application>(*args)
}
