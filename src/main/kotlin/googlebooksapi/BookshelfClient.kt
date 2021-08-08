package googlebooksapi

import googlebooksapi.model.bookshelf.Bookshelf
import googlebooksapi.model.bookshelf.BookshelfItem
import googlebooksapi.model.volume.Volume
import io.ktor.client.call.*
import io.ktor.client.statement.*

class BookshelfClient : Client() {
    suspend fun getBookshelves(url: String): Bookshelf {
        val response: HttpResponse = get(url)
        return response.receive()
    }

    suspend fun getBookshelfItem(url: String): BookshelfItem {
        val response: HttpResponse = get(url)
        return response.receive()
    }

    suspend fun getVolumesInBookshelf(url: String): Volume {
        val response: HttpResponse = get(url)
        return response.receive()
    }
}