package data.volume

import java.net.URI

data class AccessInfo(
    val country: String,
    val viewability: String,
    val embeddable: Boolean,
    val publicDomain: Boolean,
    val textToSpeechPermission: String,
    val epub: Epub,
    val pdf: Pdf,
    val webReaderLink: URI,
    val accessViewStatus: String,
    val quoteSharingAllowed: Boolean,
)