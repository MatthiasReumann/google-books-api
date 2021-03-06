package googlebooksapi.model.bookshelf

import java.net.URI

data class BookshelfItem(
    val kind: String,
    val id: Int,
    val selfLink: URI,
    val title: String,
    val description: String,
    val access: String,
    val updated: String,
    val created: String,
    val volumeCount: Int,
    val volumesLastUpdated: String
)