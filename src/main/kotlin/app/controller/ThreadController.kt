package app.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
@RequestMapping("/thread")
class ThreadController {
    @Value("\${test.property}")
    private val testProperty: String? = null

    @GetMapping("/work")
    @Throws(InterruptedException::class)
    fun hard(): String {
        logger.info("working hard")
        Thread.sleep(1000)
        return Thread.currentThread().toString()
    }

    @GetMapping("/property")
    fun property(): String? {
        return testProperty
    }

    companion object {
        private val logger: Logger = Logger.getLogger(ThreadController::class.java.name)
    }
}
