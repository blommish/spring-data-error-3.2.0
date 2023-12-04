package no.blommish

import no.blommish.repository.InsertUpdateRepository
import no.blommish.repository.RepositoryInterface
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.core.JdbcAggregateOperations
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BarRepository :
    RepositoryInterface<Bar, UUID>,
    InsertUpdateRepository<Bar>

@Component
class BarRepository2(val entityOperations: JdbcAggregateOperations) {

    fun insert(t: Bar): Bar {
        return entityOperations.insert(t)
    }
}

data class Bar(
    @Id
    val id: UUID = UUID.randomUUID(),
    @MappedCollection(idColumn = "bar_id")
    val eksternId: ExternalBarId = ExternalBarId(),
)

@Table("bar_external")
data class ExternalBarId(
    @Id
    val barExternalId: Long = 0,
)
