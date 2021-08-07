package googlebooksapi.data.bookshelf

import java.net.URI
import java.time.Instant

data class BookshelfItem(
    val kind: String,
    val id: Int,
    val selfLink: URI,
    val title: String,
    val description: String,
    val access: String,
    val updated: Instant,
    val created: Instant,
    val volumeCount: Int,
    val volumesLastUpdated: Instant
)