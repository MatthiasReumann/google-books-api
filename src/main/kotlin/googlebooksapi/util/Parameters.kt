package googlebooksapi.util

import googlebooksapi.options.FilterOption
import googlebooksapi.options.PrintTypeOption
import googlebooksapi.options.ProjectionOption
import googlebooksapi.options.SortOption

class Parameters {
    val parameters: MutableMap<String, String> = mutableMapOf()

    fun startIndex(startIndex: Int) {
        parameters.put("startIndex", startIndex.toString())
    }

    fun maxResults(maxResults: Int) {
        parameters.put("maxResults", maxResults.toString())
    }

    fun projection(projectionOption: ProjectionOption) {
        parameters.put("projection", projectionOption.string)
    }

    fun download(format: String) {
        parameters.put("download", format)
    }

    fun filter(option: FilterOption) {
        parameters.put("filter", option.toString())
    }

    fun langRestrict(language: String) {
        parameters.put("langRestrict", language)
    }

    fun orderBy(option: SortOption) {
        parameters.put("orderBy", option.string)
    }

    fun printType(type: PrintTypeOption) {
        parameters.put("printType", type.string)
    }

    override fun toString(): String {
        val s = StringBuilder()
        val cnt = 0
        if (parameters.isNotEmpty()) {
            parameters.forEach { name, value ->
                s.append("${name}=${value}&")
            }
        }
        return s.toString()
    }
}