package app.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class TableOne(
    @Id
    var id:UUID?=null,
    var description: String?=null,
    var title: String?=null,
    var col2: String?=null,
    var col3: String?=null,
    var col4: String?=null,
)