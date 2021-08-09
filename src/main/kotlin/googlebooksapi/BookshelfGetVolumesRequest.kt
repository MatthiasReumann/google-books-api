package googlebooksapi

import googlebooksapi.options.ProjectionOption
import googlebooksapi.util.Parameters
import googlebooksapi.util.StringUtils

class BookshelfGetVolumesRequest {
    val parameters = Parameters()
    var userID: String = StringUtils.EMPTY_STRING
        private set
    var bookshelfID: Int = 0
        private set

    fun userID(id: String) {
        userID = id
    }

    fun bookshelfID(id: Int) {
        bookshelfID = id
    }

    fun startIndex(startIndex: Int) = parameters.startIndex(startIndex)

    fun maxResults(maxResults: Int) = parameters.maxResults(maxResults)

    fun projection(projectionOption: ProjectionOption) = parameters.projection(projectionOption)
}