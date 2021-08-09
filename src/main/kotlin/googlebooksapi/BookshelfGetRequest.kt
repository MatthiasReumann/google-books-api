package googlebooksapi

import googlebooksapi.util.Parameters
import googlebooksapi.util.StringUtils

class BookshelfGetRequest {
    val parameters = Parameters()
    var userID: String = StringUtils.EMPTY_STRING
        private set

    fun userID(id: String) {
        userID = id
    }

    fun startIndex(startIndex: Int) = parameters.startIndex(startIndex)

    fun maxResults(maxResults: Int) = parameters.maxResults(maxResults)
}