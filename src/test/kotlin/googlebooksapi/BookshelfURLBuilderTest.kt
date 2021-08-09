package googlebooksapi

import googlebooksapi.util.Parameters
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BookshelfURLBuilderTest {
    companion object {
        val APIKEY: String = "valid-key"
        val USERID: String = "11111"
        val BOOKSHELFID: Int = 3
    }

    @Test
    fun testGetBookshelves() {
        val urlBuilder = BookshelfURLBuilder(APIKEY)
        val parameters = Parameters()
        val actual = urlBuilder.getBookshelves(userID = USERID, parameters)
        val expected = "https://www.googleapis.com/books/v1/users/$USERID/bookshelves?key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetBookshelfWithID() {
        val urlBuilder = BookshelfURLBuilder(APIKEY)
        val actual = urlBuilder.getBookshelfWithID(USERID, BOOKSHELFID)
        val expected = "https://www.googleapis.com/books/v1/users/$USERID/bookshelves/$BOOKSHELFID?key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetVolumesInBookshelf() {
        val urlBuilder = BookshelfURLBuilder(APIKEY)
        val parameters = Parameters().apply {
            maxResults(3)
        }
        val actual = urlBuilder.getVolumesInBookshelf(USERID, BOOKSHELFID, parameters)
        val expected = "https://www.googleapis.com/books/v1/users/$USERID/bookshelves/$BOOKSHELFID/volumes?maxResults=3&key=$APIKEY"
        assertEquals(expected, actual)
    }
}