package googlebooksapi

import googlebooksapi.data.volume.Item
import googlebooksapi.data.volume.Volume
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class VolumeClient : Client() {
    suspend fun get(url: String): Volume {
        val response: HttpResponse = httpClient.get(url) {}
        return response.receive()
    }

    suspend fun getSpecific(url: String): Item {
        val response: HttpResponse = httpClient.get(url) {}
        return response.receive()
    }
}