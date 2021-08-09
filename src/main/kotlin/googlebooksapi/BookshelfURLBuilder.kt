package googlebooksapi

import googlebooksapi.util.StringUtils

class BookshelfURLBuilder(private var key: String = StringUtils.EMPTY_STRING) : URLBuilder() {
    private val url: String

    init {
        url = baseURL + "/users"
    }

    fun getBookshelves(userID: String, parameters: BookshelfParameters): String {
        return "$url/$userID/bookshelves?${parameters}key=$key"
    }

    fun getBookshelfWithID(userID: String, bookshelfID: Int): String {
        return "$url/$userID/bookshelves/$bookshelfID?key=$key"
    }

    fun getVolumesInBookshelf(userID: String, bookshelfID: Int, parameters: VolumesInBookshelfParameters): String {
        return "$url/$userID/bookshelves/$bookshelfID/volumes?${parameters}key=$key"
    }
}