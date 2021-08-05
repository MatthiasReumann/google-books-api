import data.volume.Volume
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class VolumeClient : Client() {
    override suspend fun get(url: String): Volume {
        val response: HttpResponse = httpClient.get(url) {}
        return response.receive()
    }
}