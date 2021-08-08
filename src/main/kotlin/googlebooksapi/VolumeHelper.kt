package googlebooksapi

import googlebooksapi.model.volume.VolumeItem
import googlebooksapi.model.volume.Volume

class VolumeHelper(apikey: String) {
    private val urlBuilder: VolumeURLBuilder

    init {
        urlBuilder = VolumeURLBuilder(apikey)
    }

    suspend fun get(request: VolumeRequest): Volume {
        val search = VolumeSearch(request.searchText, request.fields, request.parameters)
        val url = urlBuilder.getVolumes(search)
        val client = VolumeClient()
        val volume: Volume = client.getVolumes(url)

        return volume
    }

    suspend fun getVolumeWithID(volumeID: String): VolumeItem {
        val url = urlBuilder.getVolumeWithID(volumeID)
        val client = VolumeClient()
        val volumeItem: VolumeItem = client.getVolumeItem(url)

        return volumeItem
    }
}