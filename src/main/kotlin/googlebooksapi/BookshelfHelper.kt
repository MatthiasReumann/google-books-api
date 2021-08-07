package googlebooksapi

import googlebooksapi.data.bookshelf.Bookshelf
import googlebooksapi.data.bookshelf.BookshelfItem
import googlebooksapi.data.volume.Volume
import googlebooksapi.exceptions.HelperClientException
import googlebooksapi.exceptions.HelperException
import googlebooksapi.exceptions.HelperRedirectException
import googlebooksapi.exceptions.HelperServerException
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

    suspend fun get(): Bookshelf {
        val url = urlBuilder.getBookshelves(userID)
        val client = BookshelfClient()
        val bookshelf: Bookshelf

        try {
            bookshelf = client.get(url)
        } catch (redirectException: RedirectResponseException) {
            val message = redirectException.message ?: "300 Error"
            val code = redirectException.response.status
            throw HelperRedirectException(code, message)
        } catch (clientException: ClientRequestException) {
            val message = clientException.message
            val code = clientException.response.status
            throw HelperClientException(code, message)
        } catch (serverException: ServerResponseException) {
            val message = serverException.message ?: "500 Error"
            val code = serverException.response.status
            throw HelperServerException(code, message)
        } finally {
            client.close()
        }

        return bookshelf
    }

    suspend fun getSpecific(bookshelfID: String): BookshelfItem {
        val url = urlBuilder.getSpecificBookshelf(userID, bookshelfID)
        val client = BookshelfClient()
        val item: BookshelfItem

        try {
            item = client.getSpecific(url)
        } catch (redirectException: RedirectResponseException) {
            val message = redirectException.message ?: "300 Error"
            val code = redirectException.response.status
            throw HelperRedirectException(code, message)
        } catch (clientException: ClientRequestException) {
            val message = clientException.message
            val code = clientException.response.status
            throw HelperClientException(code, message)
        } catch (serverException: ServerResponseException) {
            val message = serverException.message ?: "500 Error"
            val code = serverException.response.status
            throw HelperServerException(code, message)
        } finally {
            client.close()
        }

        return item
    }

    suspend fun getVolumesInBookshelf(bookshelfID: String): Volume {
        val url = urlBuilder.getVolumesInBookshelf(userID, bookshelfID)
        val client = BookshelfClient()
        val volumes: Volume

        try {
            volumes = client.getVolumesInBookshelf(url)
        } catch (redirectException: RedirectResponseException) {
            val message = redirectException.message ?: "300 Error"
            val code = redirectException.response.status
            throw HelperRedirectException(code, message)
        } catch (clientException: ClientRequestException) {
            val message = clientException.message
            val code = clientException.response.status
            throw HelperClientException(code, message)
        } catch (serverException: ServerResponseException) {
            val message = serverException.message ?: "500 Error"
            val code = serverException.response.status
            throw HelperServerException(code, message)
        } finally {
            client.close()
        }

        return volumes
    }
}