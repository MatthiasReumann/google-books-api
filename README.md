# googlebooksapi
A wrapper of the [Google Books APIs](https://developers.google.com/books) written in Kotlin

## Usage

### Volumes
```kotlin 
val volumeHelper = VolumeHelper("API_KEY")
```

###### Get volumes

``` kotlin
val request = VolumeRequest().apply {
    inauthor("Michael Pollan")
    inpublisher("Penguin")
    intitle("This Is Your Mind On Plants")
    sorting(SortOption.NEWEST)
    printType(PrintTypeOption.BOOKS)
    projection(ProjectionOption.FULL)
    maxResults(3)
}
val volume: Volume = volumeHelper.get(request)
```

###### Get specific volume

``` kotlin
val volumeItem: VolumeItem = volumeHelper.getVolumeWithID("wVyWswEACAAJ")
```

### Bookshelves

```kotlin
val bookshelfHelper = BookshelfHelper("API_KEY")
```

###### Get bookshelves

``` kotlin
val bookshelves: Bookshelf = bookshelfHelper.get("1112223334445556677")
```

###### Get specific bookshelf

```kotlin
val bookshelf: BookshelfItem = bookshelfHelper.getBookshelfWithID("1112223334445556677", 1001)
```

###### Get volumes in bookshelf

```kotlin
val item: Volume = bookshelfHelper.getVolumesInBookshelf("1164450273332089480971", 1001)
```

## Download

### Groovy
```gradle
allprojects {
  repositories {
      maven { url "https://jitpack.io" }
  }
}

dependencies {
   implementation 'com.github.MatthiasReumann:googlebooksapi:master-SNAPSHOT'
}
```

### Kotlin DSL

``` gradle
allprojects {
  repositories {
    maven { url = uri("https://www.jitpack.io") }
  }
}

dependencies {
   implementation("com.github.MatthiasReumann:googlebooksapi:master-SNAPSHOT")
}
```

