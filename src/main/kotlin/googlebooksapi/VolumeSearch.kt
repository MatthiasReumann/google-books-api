package googlebooksapi

import java.lang.StringBuilder

class VolumeSearch(
    private val searchText: String,
    private val fields: MutableMap<String, String>,
    private val parameters: MutableMap<String, String>
) {
    override fun toString(): String {
        val sb = StringBuilder("?q=")

        appendSearchText(sb)
        appendFields(sb)
        appendParameters(sb)

        return sb.toString()
    }

    private fun appendSearchText(s: StringBuilder){
        if (searchText.isNotEmpty()) {
            s.append(searchText)

            if (fields.isNotEmpty()) {
                s.append("+")
            }
        }
    }

    private fun appendFields(s: StringBuilder){
        val lastIndex = fields.size - 1
        var idx = 0
        fields.forEach { name, value ->
            s.append("${name}:${value}")
            if (idx < lastIndex) s.append("+")
            idx++
        }
    }

    private fun appendParameters(s: StringBuilder) {
        if (parameters.isNotEmpty()) {
            parameters.forEach { name, value ->
                s.append("&${name}=${value}")
            }
        }
    }
}