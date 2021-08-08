package googlebooksapi.model.bookshelf

data class Bookshelf(
    val kind: String,
    val items: List<BookshelfItem>
)