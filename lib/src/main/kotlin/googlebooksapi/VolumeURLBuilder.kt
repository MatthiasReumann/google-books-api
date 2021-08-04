package googlebooksapi

class VolumeURLBuilder(private var key: String = StringUtils.EMPTY_STRING) : URLBuilder() {
    fun getURL(volumeSearch: VolumeSearch): String {
        return "${baseURL}/volumes${volumeSearch}&key=${key}"
    }

    fun getByIdURL(volumeId: String): String {
        return "${baseURL}/volumes/${volumeId}&key=${key}"
    }
}