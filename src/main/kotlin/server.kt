import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    routing {
        get("/foo") {
            call.respondText { "foo" }
        }

        get("/bar") {
            call.respondText { "bar" }
        }
    }
}