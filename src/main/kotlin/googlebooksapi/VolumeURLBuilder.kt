package googlebooksapi

import googlebooksapi.options.ProjectionOption
import googlebooksapi.util.Parameters
import googlebooksapi.util.StringUtils

class VolumeURLBuilder(private var key: String = StringUtils.EMPTY_STRING) : URLBuilder() {
    fun getVolumes(search: VolumeQuery, parameters: Parameters): String {
        return "${baseURL}/volumes?${search}${parameters}key=${key}"
    }

    fun getVolumeWithID(volumeID: String, projectionOption: ProjectionOption = ProjectionOption.FULL): String {
        return "${baseURL}/volumes/$volumeID?projection=$projectionOption&key=${key}"
    }
}