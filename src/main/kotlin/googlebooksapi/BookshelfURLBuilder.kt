package googlebooksapi

import googlebooksapi.exceptions.InvalidUserIdException
import java.lang.StringBuilder

class BookshelfURLBuilder(private var key: String = StringUtils.EMPTY_STRING) : URLBuilder() {
    private val url: String

    init {
        url = baseURL + "/users"
    }

    fun getURL(userID: String): String {
        if (userID.isEmpty()) {
            throw InvalidUserIdException("UserID is empty")
        }
        return "$url/$userID/bookshelves?key=$key"
    }

    fun getURLByBookshelfID(userID: String, bookshelfID: String): String {
        return "$url/$userID/bookshelves/$bookshelfID?key=$key"
    }
}