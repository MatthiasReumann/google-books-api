package googlebooksapi

import googlebooksapi.options.*
import googlebooksapi.util.StringUtils

class VolumeRequest {
    val fields: MutableMap<String, String>
    val parameters: MutableMap<String, String>
    var searchText: String
        private set

    init {
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
}