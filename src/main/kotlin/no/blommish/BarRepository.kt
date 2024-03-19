package no.blommish

import no.blommish.repository.InsertUpdateRepository
import no.blommish.repository.RepositoryInterface
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.core.JdbcAggregateOperations
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BarRepository : RepositoryInterface<Bar, BarId>, InsertUpdateRepository<Bar>

@Component
class BarRepository2(val entityOperations: JdbcAggregateOperations) {

    fun insert(t: Bar): Bar {
        return entityOperations.insert(t)
    }
}

@JvmInline
value class BarId(val id: UUID)
data class Bar(
    @Id
    val id: BarId = BarId(UUID.randomUUID()),
)