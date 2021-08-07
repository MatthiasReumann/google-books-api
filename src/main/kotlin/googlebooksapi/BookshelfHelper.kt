package googlebooksapi

import googlebooksapi.data.bookshelf.Bookshelf
import googlebooksapi.data.bookshelf.BookshelfItem
import googlebooksapi.data.volume.Volume
import googlebooksapi.exceptions.HelperException
import googlebooksapi.options.FilterOption
import googlebooksapi.options.PrintTypeOption
import googlebooksapi.options.ProjectionOption
import googlebooksapi.options.SortOption
import io.ktor.client.features.*

class BookshelfHelper(apikey: String) {
    private val urlBuilder: BookshelfURLBuilder
    private var userID: String

    init {
        urlBuilder = BookshelfURLBuilder(apikey)
        userID = StringUtils.EMPTY_STRING
    }

    fun userID(id: String) {
        userID = id
    }

    suspend fun getAll(): Bookshelf {
        val url = urlBuilder.getURL(userID)
        val client = BookshelfClient()
        val bookshelf: Bookshelf

        try {
            bookshelf = client.getAll(url)
        } catch (redirectException: RedirectResponseException) {
            throw HelperException(redirectException.message ?: "3xx received")
        } catch (clientException: ClientRequestException) {
            throw HelperException(clientException.message)
        } catch (serverException: ServerResponseException) {
            throw HelperException(serverException.message ?: "5xx received")
        } finally {
            client.close()
        }

        return bookshelf
    }

    suspend fun get(bookshelfID: String): BookshelfItem {
        val url = urlBuilder.getURLByBookshelfID(userID, bookshelfID)
        val client = BookshelfClient()
        val item: BookshelfItem

        try {
            item = client.get(url)
        } catch (redirectException: RedirectResponseException) {
            throw HelperException(redirectException.message ?: "3xx received")
        } catch (clientException: ClientRequestException) {
            throw HelperException(clientException.message)
        } catch (serverException: ServerResponseException) {
            throw HelperException(serverException.message ?: "5xx received")
        } finally {
            client.close()
        }

        return item
    }
}