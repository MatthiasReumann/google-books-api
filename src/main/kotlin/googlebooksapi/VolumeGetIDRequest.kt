package googlebooksapi

import googlebooksapi.options.ProjectionOption
import googlebooksapi.util.StringUtils

class VolumeGetIDRequest {
    var volumeID: String = StringUtils.EMPTY_STRING
        private set
    var projectionOption: ProjectionOption = ProjectionOption.FULL
        private set

    fun volumeID(id: String){
        volumeID = id
    }

    fun projection(projectionOption: ProjectionOption){
        this.projectionOption = projectionOption
    }
}