package com.twsihan.examples.configuration

import com.twsihan.examples.jobs.ExampleJob
import org.quartz.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JobConfiguration
{
    companion object {
        const val EXAMPLE_JOB_NAME = "example"
    }


    @Bean
    fun communicationJobDetail(): JobDetail
    {
        return JobBuilder.newJob(ExampleJob::class.java)
            .withIdentity(EXAMPLE_JOB_NAME)
            .storeDurably()
            .build()
    }

    @Bean
    fun communicationQueueJobTrigger(): Trigger
    {
        return TriggerBuilder.newTrigger()
            .forJob(communicationJobDetail())
            .withIdentity(EXAMPLE_JOB_NAME)
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
            .build()
    }
}
