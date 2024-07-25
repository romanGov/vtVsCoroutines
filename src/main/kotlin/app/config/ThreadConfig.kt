package app.config

import jakarta.annotation.PostConstruct
import org.apache.coyote.ProtocolHandler
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.task.AsyncTaskExecutor
import org.springframework.core.task.support.TaskExecutorAdapter
import org.springframework.scheduling.annotation.EnableAsync
import java.util.concurrent.Executors
import java.util.logging.Logger

@EnableAsync
@Configuration
@ConditionalOnProperty(value = ["spring.thread-executor"], havingValue = "virtual")
class ThreadConfig {
    @Bean
    fun applicationTaskExecutor(): AsyncTaskExecutor {
        return TaskExecutorAdapter(Executors.newVirtualThreadPerTaskExecutor())
    }

    @Bean
    fun protocolHandlerVirtualThreadExecutorCustomizer(): TomcatProtocolHandlerCustomizer<*> {
        return TomcatProtocolHandlerCustomizer { protocolHandler: ProtocolHandler ->
            protocolHandler.executor = Executors.newVirtualThreadPerTaskExecutor()
        }
    }

    @PostConstruct
    fun init() {
        logger.info("Starting virtual thread Config")
    }

    companion object {
        private val logger: Logger = Logger.getLogger(ThreadConfig::class.java.name)
    }
}
