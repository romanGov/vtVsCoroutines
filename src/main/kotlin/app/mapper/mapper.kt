package app.mapper

import app.dto.TableDto
import app.entity.TableOne

fun TableOne.toDto(): TableDto {
    return TableDto(id, description)
}