package googlebooksapi

import kotlin.test.Test
import kotlin.test.assertEquals

internal class VolumeURLBuilderTest {

    companion object {
        val EMPTY_MAP: MutableMap<String, String> = mutableMapOf()
        val EMPTY_STRING: String = ""

        val APIKEY: String = "valid-key"
        val SEARCHTEXT: String = "limit"
        val ISBN: String = "978-3-596-18488-0"
        val AUTHOR: String = "Frank"
        val DOWNLOAD: String = "epub"
        val PRINTTYPE: String = PrintTypeOption.BOOKS.string

        val SINGLE_FIELD: MutableMap<String, String> = mutableMapOf("isbn" to ISBN)
        val FIELDS: MutableMap<String, String> = mutableMapOf("isbn" to ISBN, "inauthor" to AUTHOR)
        val PARAMETERS: MutableMap<String, String> =
            mutableMapOf("download" to DOWNLOAD, "printType" to PRINTTYPE)
    }

    private val volumeRequestBuilder = VolumeURLBuilder(APIKEY)

    @Test
    fun testGetURLEmptySearch() {
        val search = VolumeSearch(EMPTY_STRING, EMPTY_MAP, EMPTY_MAP)
        val actual = volumeRequestBuilder.getURL(search)
        val expected = "https://www.googleapis.com/books/v1/volumes?q=&key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetURLWithSearchTextOnly() {
        val search = VolumeSearch(SEARCHTEXT, EMPTY_MAP, EMPTY_MAP)
        val actual = volumeRequestBuilder.getURL(search)
        val expected = "https://www.googleapis.com/books/v1/volumes?q=$SEARCHTEXT&key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetURLWithField() {
        val search = VolumeSearch(SEARCHTEXT, SINGLE_FIELD, EMPTY_MAP)
        val actual = volumeRequestBuilder.getURL(search)
        val expected = "https://www.googleapis.com/books/v1/volumes?q=$SEARCHTEXT+isbn:$ISBN&key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetURLWithFields() {
        val search = VolumeSearch(SEARCHTEXT, FIELDS, EMPTY_MAP)
        val actual = volumeRequestBuilder.getURL(search)
        val expected =
            "https://www.googleapis.com/books/v1/volumes?q=$SEARCHTEXT+isbn:$ISBN+inauthor:$AUTHOR&key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetURLWithParameters() {
        val search = VolumeSearch(SEARCHTEXT, EMPTY_MAP, PARAMETERS)
        val actual = volumeRequestBuilder.getURL(search)
        val expected =
            "https://www.googleapis.com/books/v1/volumes?q=$SEARCHTEXT&download=$DOWNLOAD&printType=$PRINTTYPE&key=$APIKEY"
        assertEquals(expected, actual)
    }
}