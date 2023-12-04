package no.blommish

import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@Configuration
@EnableJdbcAuditing
@EnableJdbcRepositories("no.blommish")
@SpringBootConfiguration // Appconfig
class DatabaseConfiguration : AbstractJdbcConfiguration()
