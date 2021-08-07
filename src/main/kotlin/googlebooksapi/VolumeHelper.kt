package googlebooksapi

import googlebooksapi.data.volume.Item
import googlebooksapi.data.volume.Volume
import googlebooksapi.exceptions.HelperClientException
import googlebooksapi.exceptions.HelperRedirectException
import googlebooksapi.exceptions.HelperServerException
import googlebooksapi.options.FilterOption
import googlebooksapi.options.PrintTypeOption
import googlebooksapi.options.ProjectionOption
import googlebooksapi.options.SortOption
import io.ktor.client.features.*

class VolumeHelper(apikey: String) {
    private val urlBuilder: VolumeURLBuilder
    private val fields: MutableMap<String, String>
    private val parameters: MutableMap<String, String>
    private var searchText: String

    init {
        urlBuilder = VolumeURLBuilder(apikey)
        fields = mutableMapOf()
        parameters = mutableMapOf()
        searchText = StringUtils.EMPTY_STRING
    }

    fun search(text: String) {
        searchText = text
    }

    fun intitle(title: String) {
        fields.put("intitle", title)
    }

    fun inauthor(author: String) {
        fields.put("inauthor", author)
    }

    fun inpublisher(publisher: String) {
        fields.put("inpublisher", publisher)
    }

    fun subject(subject: String) {
        fields.put("subject", subject)
    }

    fun isbn(isbn: String) {
        fields.put("isbn", isbn)
    }

    fun lccn(lccn: String) {
        fields.put("lccn", lccn)
    }

    fun oclc(oclc: String) {
        fields.put("oclc", oclc)
    }

    fun download(format: String) {
        parameters.put("download", format)
    }

    fun filter(option: FilterOption) {
        parameters.put("filter", option.string)
    }

    fun startIndex(startIndex: Int) {
        parameters.put("startIndex", startIndex.toString())
    }

    fun maxResults(maxResults: Int) {
        parameters.put("maxResults", maxResults.toString())
    }

    fun printType(type: PrintTypeOption) {
        parameters.put("printType", type.string)
    }

    fun projection(projectionOption: ProjectionOption) {
        parameters.put("projection", projectionOption.string)
    }

    fun sorting(option: SortOption) {
        parameters.put("orderBy", option.string)
    }

    suspend fun get(): Volume {
        val search = VolumeSearch(searchText, fields, parameters)
        val url = urlBuilder.getVolumes(search)
        val client = VolumeClient()
        val volume: Volume
        try {
            volume = client.get(url)
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
        return volume
    }

    suspend fun getSpecific(volumeId: String): Item {
        val url = urlBuilder.getSpecificVolume(volumeId)
        val client = VolumeClient()
        val item: Item
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
}