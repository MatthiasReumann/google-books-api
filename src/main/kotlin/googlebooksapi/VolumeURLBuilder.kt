package googlebooksapi

import googlebooksapi.util.StringUtils

class VolumeURLBuilder(private var key: String = StringUtils.EMPTY_STRING) : URLBuilder() {
    fun getVolumes(volumeSearch: VolumeSearch): String {
        return "${baseURL}/volumes${volumeSearch}&key=${key}"
    }

    fun getVolumeWithID(volumeId: String): String {
        return "${baseURL}/volumes/${volumeId}?key=${key}"
    }
}