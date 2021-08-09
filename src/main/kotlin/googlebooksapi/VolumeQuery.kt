package googlebooksapi

import googlebooksapi.util.StringUtils
import java.lang.StringBuilder

class VolumeQuery {
    private var searchText: String = StringUtils.EMPTY_STRING
    private val fields: MutableMap<String, String> = mutableMapOf()

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

    override fun toString(): String {
        val sb = StringBuilder("q=")

        appendSearchText(sb)
        appendFields(sb)

        sb.append("&")

        return sb.toString()
    }

    private fun appendSearchText(s: StringBuilder) {
        if (searchText.isNotEmpty()) {
            s.append(searchText)

            if (fields.isNotEmpty()) {
                s.append("+")
            }
        }
    }

    private fun appendFields(s: StringBuilder) {
        val lastIndex = fields.size - 1
        var idx = 0
        fields.forEach { name, value ->
            s.append("${name}:${value}")
            if (idx < lastIndex) s.append("+")
            idx++
        }
    }
}