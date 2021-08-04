package googlebooksapi.data.volume

data class Volume(
    val kind: String,
    val totalItems: Int,
    val items: List<Item>,
)