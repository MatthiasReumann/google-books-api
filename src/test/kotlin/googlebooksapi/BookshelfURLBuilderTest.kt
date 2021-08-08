package googlebooksapi

import googlebooksapi.exception.InvalidUserIdException
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
        urlBuilder.getBookshelves(userID = EMPTY_STRING)
    }

    @Test
    fun testGetBookshelves() {
        val urlBuilder = BookshelfURLBuilder(KEY)
        val actual = urlBuilder.getBookshelves(userID = USERID)
        val expected = "https://www.googleapis.com/books/v1/users/$USERID/bookshelves?key=$KEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetSpecificBookshelf(){
        val urlBuilder = BookshelfURLBuilder(KEY)
        val actual = urlBuilder.getBookshelfWithID(USERID, BOOKSHELFID)
        val expected = "https://www.googleapis.com/books/v1/users/$USERID/bookshelves/$BOOKSHELFID?key=$KEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetVolumesInBookshelf(){
        val urlBuilder = BookshelfURLBuilder(KEY)
        val actual = urlBuilder.getVolumesInBookshelf(USERID, BOOKSHELFID)
        val expected = "https://www.googleapis.com/books/v1/users/$USERID/bookshelves/$BOOKSHELFID/volumes?key=$KEY"
        assertEquals(expected, actual)
    }
}