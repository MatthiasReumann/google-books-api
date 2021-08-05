import data.volume.Volume
import io.ktor.client.*
import io.ktor.client.features.json.*

abstract class Client {
    protected val httpClient: HttpClient

    init {
        httpClient = HttpClient {
            install(JsonFeature)
        }
    }

    fun close(){
        httpClient.close()
    }

    abstract suspend fun get(url: String): Volume
}