package org.jesperancinha.smtd.mixservice

import org.jesperancinha.smtd.mixservice.configuration.InventoryProcessor
import org.jesperancinha.smtd.mixservice.configuration.MySingletonComponent
import org.jesperancinha.smtd.mixservice.configuration.Notification
import org.jesperancinha.smtd.mixservice.configuration.NotificationService
import org.jesperancinha.smtd.mixservice.domain.Test
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(Test::class)
@SpringBootApplication
class MixServiceApplication(
    private val notificationService: NotificationService,
    private val inventoryProcessor: InventoryProcessor,
    private val mySingletonComponent: MySingletonComponent,
    private val test: Test
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        notificationService.notifyByEmail()
        notificationService.notifyBySMS()

        process(notificationService.smsNotification)
        process(notificationService.emailNotification)

        inventoryProcessor.performAll()

        mySingletonComponent.sayHello()
        MySingletonComponent.sayHello()

        println(test)
    }

    private fun process(notificationEmail: Notification) {
        when (notificationEmail) {
            is Notification.SMS -> println("SMS")
            is Notification.Email -> println("Email")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<MixServiceApplication>(*args)
}
