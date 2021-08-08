package googlebooksapi.model.volume

data class Volume(
    val kind: String,
    val totalItems: Int,
    val items: List<VolumeItem>,
)