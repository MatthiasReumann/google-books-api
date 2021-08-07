package googlebooksapi

import googlebooksapi.exceptions.InvalidUserIdException
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BookshelfURLBuilderTest {
    companion object {
        val EMPTY_STRING: String = ""

        val KEY: String = "xxxx"
        val USERID: String = "11111"
        val BOOKSHELFID: String = "3"
    }

    @Test(InvalidUserIdException::class)
    fun testGetURLEmptyUserID() {
        val urlBuilder = BookshelfURLBuilder(KEY)
        urlBuilder.getURL(userID = EMPTY_STRING)
    }

    @Test
    fun testGetURLValid() {
        val urlBuilder = BookshelfURLBuilder(KEY)
        val actual = urlBuilder.getURL(userID = USERID)
        val expected = "https://www.googleapis.com/books/v1/users/$USERID/bookshelves?key=$KEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetURLByBookshelfID(){
        val urlBuilder = BookshelfURLBuilder(KEY)
        val actual = urlBuilder.getURLByBookshelfID(USERID, BOOKSHELFID)
        val expected = "https://www.googleapis.com/books/v1/users/$USERID/bookshelves/$BOOKSHELFID?key=$KEY"
        assertEquals(expected, actual)
    }
}