package googlebooksapi

class VolumeURLBuilder(private var key: String = StringUtils.EMPTY_STRING) : URLBuilder() {
    fun getVolumes(volumeSearch: VolumeSearch): String {
        return "${baseURL}/volumes${volumeSearch}&key=${key}"
    }

    fun getSpecificVolume(volumeId: String): String {
        return "${baseURL}/volumes/${volumeId}?key=${key}"
    }
}