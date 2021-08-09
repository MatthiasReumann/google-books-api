package googlebooksapi

import googlebooksapi.options.PrintTypeOption
import googlebooksapi.options.ProjectionOption
import googlebooksapi.util.Parameters
import kotlin.test.Test
import kotlin.test.assertEquals

internal class VolumeURLBuilderTest {

    companion object {
        val APIKEY: String = "valid-key"
        val SEARCHTEXT: String = "limit"
        val ISBN: String = "978-3-596-18488-0"
        val AUTHOR: String = "Frank"
        val DOWNLOAD: String = "epub"
        val PRINTTYPE: PrintTypeOption = PrintTypeOption.BOOKS
    }

    private val volumeRequestBuilder = VolumeURLBuilder(APIKEY)

    @Test
    fun testGetVolumesEmptySearch() {
        val search = VolumeQuery()
        val actual = volumeRequestBuilder.getVolumes(search, Parameters())
        val expected = "https://www.googleapis.com/books/v1/volumes?q=&key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetVolumesWithSearchTextOnly() {
        val search = VolumeQuery().apply {
            search(SEARCHTEXT)
        }

        val actual = volumeRequestBuilder.getVolumes(search, Parameters())
        val expected = "https://www.googleapis.com/books/v1/volumes?q=$SEARCHTEXT&key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetVolumesWithField() {
        val search = VolumeQuery().apply {
            search(SEARCHTEXT)
            isbn(ISBN)
        }
        val parameters = Parameters()
        val actual = volumeRequestBuilder.getVolumes(search, parameters)
        val expected = "https://www.googleapis.com/books/v1/volumes?q=$SEARCHTEXT+isbn:$ISBN&key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetVolumesWithFields() {
        val search = VolumeQuery().apply {
            search(SEARCHTEXT)
            isbn(ISBN)
            inauthor(AUTHOR)
        }
        val actual = volumeRequestBuilder.getVolumes(search, Parameters())
        val expected =
            "https://www.googleapis.com/books/v1/volumes?q=$SEARCHTEXT+isbn:$ISBN+inauthor:$AUTHOR&key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetVolumesWithParameters() {
        val search = VolumeQuery().apply {
            search(SEARCHTEXT)
        }
        val parameters = Parameters().apply {
            download(DOWNLOAD)
            printType(PRINTTYPE)
        }
        val actual = volumeRequestBuilder.getVolumes(search, parameters)
        val expected =
            "https://www.googleapis.com/books/v1/volumes?q=$SEARCHTEXT&download=$DOWNLOAD&printType=$PRINTTYPE&key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetSpecificVolumeDefaultProjection() {
        val actual = volumeRequestBuilder.getVolumeWithID("ID")
        val expected =
            "https://www.googleapis.com/books/v1/volumes/ID?projection=full&key=$APIKEY"
        assertEquals(expected, actual)
    }

    @Test
    fun testGetSpecificVolumeWithProjection() {
        val actual = volumeRequestBuilder.getVolumeWithID("ID", ProjectionOption.LITE)
        val expected =
            "https://www.googleapis.com/books/v1/volumes/ID?projection=lite&key=$APIKEY"
        assertEquals(expected, actual)
    }
}