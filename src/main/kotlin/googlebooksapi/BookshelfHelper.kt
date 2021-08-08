package googlebooksapi

import googlebooksapi.model.bookshelf.Bookshelf
import googlebooksapi.model.bookshelf.BookshelfItem
import googlebooksapi.model.volume.Volume

class BookshelfHelper(apikey: String) {
    private val urlBuilder: BookshelfURLBuilder

    init {
        urlBuilder = BookshelfURLBuilder(apikey)
    }

    suspend fun get(userID: String): Bookshelf {
        val url = urlBuilder.getBookshelves(userID)
        val client = BookshelfClient()
        val bookshelf: Bookshelf = client.getBookshelves(url)

        return bookshelf
    }

    suspend fun getBookshelfWithID(userID: String, bookshelfID: Int): BookshelfItem {
        val url = urlBuilder.getBookshelfWithID(userID, bookshelfID.toString())
        val client = BookshelfClient()
        val item: BookshelfItem = client.getBookshelfItem(url)

        return item
    }

    suspend fun getVolumesInBookshelf(userID: String, bookshelfID: Int): Volume {
        val url = urlBuilder.getVolumesInBookshelf(userID, bookshelfID.toString())
        val client = BookshelfClient()
        val volumes: Volume = client.getVolumesInBookshelf(url)

        return volumes
    }
}