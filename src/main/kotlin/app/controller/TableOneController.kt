package app.controller

import app.dto.TableDto
import app.mapper.toDto
import app.repository.TableOneRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TableOneController(
    private val tableOneRepository: TableOneRepository
) {
    @GetMapping("/tableOne")
    fun tableOne(): List<TableDto> {
        return tableOneRepository.findAll().map {
            it.toDto()
        }
    }
}
