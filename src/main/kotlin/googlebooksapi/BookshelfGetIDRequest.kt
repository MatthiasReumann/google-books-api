package googlebooksapi

import googlebooksapi.util.Parameters
import googlebooksapi.util.StringUtils

class BookshelfGetIDRequest {
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
}