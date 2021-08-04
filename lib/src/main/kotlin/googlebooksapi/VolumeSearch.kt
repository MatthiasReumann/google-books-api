package googlebooksapi

import java.lang.StringBuilder

class VolumeSearch(
    private val searchText: String,
    private val fields: MutableMap<String, String>,
    private val parameters: MutableMap<String, String>
) {
    override fun toString(): String {
        val sb = StringBuilder("?q=")
        if (searchText.isNotEmpty()) {
            sb.append(searchText)

            if (fields.isNotEmpty()) {
                sb.append("+")
            }
        }

        val lastIndex = fields.size - 1
        var idx = 0
        fields.forEach { name, value ->
            sb.append("${name}:${value}")
            if (idx < lastIndex) sb.append("+")
            idx++
        }

        if (parameters.isNotEmpty()) {
            parameters.forEach { name, value ->
                sb.append("&${name}=${value}")
            }
        }
        return sb.toString()
    }
}