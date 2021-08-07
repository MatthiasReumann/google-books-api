package googlebooksapi

import googlebooksapi.data.bookshelf.Bookshelf
import googlebooksapi.data.bookshelf.BookshelfItem
import googlebooksapi.data.volume.Volume
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class BookshelfClient : Client() {
    suspend fun getAll(url: String): Bookshelf {
        val response: HttpResponse = httpClient.get(url) {}
        return response.receive()
    }

    suspend fun get(url: String): BookshelfItem {
        val response: HttpResponse = httpClient.get(url) {}
        return response.receive()
    }
}