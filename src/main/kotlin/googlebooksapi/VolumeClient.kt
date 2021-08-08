package googlebooksapi

import googlebooksapi.model.volume.VolumeItem
import googlebooksapi.model.volume.Volume
import io.ktor.client.call.*
import io.ktor.client.statement.*

class VolumeClient : Client() {
    suspend fun getVolumes(url: String): Volume {
        val response: HttpResponse = get(url)
        return response.receive()
    }

    suspend fun getVolumeItem(url: String): VolumeItem {
        val response: HttpResponse = get(url)
        return response.receive()
    }
}