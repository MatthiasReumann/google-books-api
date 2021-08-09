package googlebooksapi.options

enum class SortOption(val string: String) {
    RELEVANCE("relevance") {
        override fun toString(): String {
            return string
        }
    },
    NEWEST("newest") {
        override fun toString(): String {
            return string
        }
    }
}