import com.typesafe.config.ConfigFactory
import io.ktor.config.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

class SimpleTest {
    private val testEnv = createTestEnvironment {
        config = HoconApplicationConfig(ConfigFactory.load("application.conf"))
    }

    @Test
    fun testing1() {
        withApplication(testEnv) {
            handleRequest(HttpMethod.Get, "/foo").apply {
                assertEquals("foo", response.content)
            }
        }
    }

    @Test
    fun testing2() {
        withApplication(testEnv) {
            handleRequest(HttpMethod.Get, "/bar").apply {
                assertEquals("bar", response.content)
            }
        }
    }
}