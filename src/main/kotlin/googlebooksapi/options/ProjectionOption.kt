package googlebooksapi.options

enum class ProjectionOption(val string: String) {
    FULL("full") {
        override fun toString(): String {
            return string
        }
    },
    LITE("lite"){
        override fun toString(): String {
            return string
        }
    },
}