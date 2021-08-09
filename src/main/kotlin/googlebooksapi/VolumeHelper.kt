package googlebooksapi

import googlebooksapi.model.volume.VolumeItem
import googlebooksapi.model.volume.Volume
import googlebooksapi.options.ProjectionOption

class VolumeHelper(apikey: String) {
    private val urlBuilder: VolumeURLBuilder

    init {
        urlBuilder = VolumeURLBuilder(apikey)
    }

    suspend fun get(request: VolumeGetRequest): Volume {
        val url = urlBuilder.getVolumes(request.query, request.parameters)
        val client = VolumeClient()
        val volume: Volume = client.getVolumes(url)

        return volume
    }

    suspend fun getVolumeWithID(request: VolumeGetIDRequest): VolumeItem {
        val url = urlBuilder.getVolumeWithID(request.volumeID, request.projectionOption)
        val client = VolumeClient()
        val volumeItem: VolumeItem = client.getVolumeItem(url)

        return volumeItem
    }
}