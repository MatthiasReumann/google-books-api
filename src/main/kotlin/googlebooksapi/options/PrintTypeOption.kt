package googlebooksapi.options

enum class PrintTypeOption(val string: String) {
    ALL("all") {
        override fun toString(): String {
            return string
        }
    },
    BOOKS("books") {
        override fun toString(): String {
            return string
        }
    },
    MAGAZINES("magazines") {
        override fun toString(): String {
            return string
        }
    }
}