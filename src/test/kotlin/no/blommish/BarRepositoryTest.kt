package no.blommish

import no.blommish.repository.findByIdOrThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(initializers = [DbContainerInitializer::class])
@SpringBootTest(classes = [App::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BarRepositoryTest {

    @Autowired
    lateinit var barRepository: BarRepository

    @Autowired
    lateinit var barRepository2: BarRepository2

    @Test
    fun `happy case`() {
        val bar = Bar()
        barRepository.insert(bar)
        val barFromDb = barRepository.findByIdOrThrow(bar.id)
    }

    @Test
    fun `happy case 2`() {
        val bar = Bar()
        barRepository2.insert(bar)
        val barFromDb = barRepository.findByIdOrThrow(bar.id)
    }

    @Test
    fun `happy case 3`() {
        val bar = Bar()
        barRepository.insert(bar)
        val barFromDb = barRepository.findByIdOrNull(bar.id)
    }
}
