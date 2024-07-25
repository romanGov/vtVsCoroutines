package app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class VirtualApp
fun main(args: Array<String>) {
        SpringApplication.run(VirtualApp::class.java, *args)
    }
