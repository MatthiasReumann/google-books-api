package googlebooksapi.options

enum class FilterOption(val string: String) {
    PARTIAL("partial") {
        override fun toString(): String {
            return string
        }
    },
    FULL("full") {
        override fun toString(): String {
            return string
        }
    },
    FREE_EBOOKS("free-ebooks") {
        override fun toString(): String {
            return string
        }
    },
    PAID_EBOOKS("paid-ebooks") {
        override fun toString(): String {
            return string
        }
    },
    EBOOKS("ebooks") {
        override fun toString(): String {
            return string
        }
    }
}