package googlebooksapi

import googlebooksapi.exception.InvalidBookshelfRequest
import googlebooksapi.model.bookshelf.Bookshelf
import googlebooksapi.model.bookshelf.BookshelfItem
import googlebooksapi.model.volume.Volume
import googlebooksapi.util.Parameters

typealias BookshelfParameters = Parameters
typealias VolumesInBookshelfParameters = Parameters

class BookshelfHelper(apikey: String) {
    companion object {
        val BOOKSHELF_MIN_ID: Int = 1001
    }

    private val urlBuilder: BookshelfURLBuilder

    init {
        urlBuilder = BookshelfURLBuilder(apikey)
    }

    suspend fun get(request: BookshelfGetRequest): Bookshelf {
        userIdValid(request.userID)

        val url = urlBuilder.getBookshelves(request.userID, request.parameters)
        val client = BookshelfClient()
        val bookshelf: Bookshelf = client.getBookshelves(url)

        return bookshelf
    }

    suspend fun getBookshelfWithID(request: BookshelfGetIDRequest): BookshelfItem {
        userIdValid(request.userID)
        bookshelfIdValid(request.bookshelfID)

        val url = urlBuilder.getBookshelfWithID(request.userID, request.bookshelfID)
        val client = BookshelfClient()
        val item: BookshelfItem = client.getBookshelfItem(url)

        return item
    }

    suspend fun getVolumesInBookshelf(request: BookshelfGetVolumesRequest): Volume {
        userIdValid(request.userID)
        bookshelfIdValid(request.bookshelfID)

        val url = urlBuilder.getVolumesInBookshelf(request.userID, request.bookshelfID, request.parameters)
        val client = BookshelfClient()
        val volumes: Volume = client.getVolumesInBookshelf(url)

        return volumes
    }

    private fun userIdValid(userID: String) {
        if (userID.isEmpty()) {
            throw InvalidBookshelfRequest("UserID is empty")
        }
    }

    private fun bookshelfIdValid(bookshelfID: Int) {
        if (bookshelfID < BOOKSHELF_MIN_ID) {
            throw InvalidBookshelfRequest("Invalid bookshelfID")
        }
    }
}