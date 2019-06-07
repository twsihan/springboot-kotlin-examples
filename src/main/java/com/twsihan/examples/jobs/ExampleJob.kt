package com.twsihan.examples.jobs

import com.twsihan.examples.entities.mongodb.Example
import org.apache.logging.log4j.LogManager
import org.quartz.DisallowConcurrentExecution
import org.quartz.JobExecutionContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.scheduling.quartz.QuartzJobBean

@DisallowConcurrentExecution
class ExampleJob : QuartzJobBean()
{
    companion object {
        private val logger = LogManager.getLogger(ExampleJob::class.java)
    }

    @Autowired
    lateinit var stringRedisTemplate: StringRedisTemplate

    @Autowired
    lateinit var mongoTemplate: MongoTemplate


    override fun executeInternal(jobExecutionContext: JobExecutionContext)
    {
        runCatching {
            logger.info("hello job")
            mongoTemplate.save(Example("springboot-examples-val"))
            stringRedisTemplate.opsForValue().set("springboot-examples-key", mongoTemplate.findAll(Example::class.java).toString())
            logger.info(stringRedisTemplate.opsForValue().get("springboot-examples-key"))
        }.onFailure {
            logger.error("job fail: $it")
        }
    }
}
