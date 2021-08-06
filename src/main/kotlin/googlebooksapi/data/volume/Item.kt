package googlebooksapi.data.volume

import java.net.URI

data class Item(
    val kind: String,
    val id: String,
    val etag: String,
    val selfLink: URI,
    val volumeInfo: VolumeInfo,
    val saleInfo: SaleInfo,
    val accessInfo: AccessInfo,
    val searchInfo: SearchInfo,
)