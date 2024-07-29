package app.repository

import app.entity.TableOne
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TableOneRepository: JpaRepository<TableOne, UUID>