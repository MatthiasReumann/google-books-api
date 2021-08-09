# googlebooksapi
[![](https://jitpack.io/v/MatthiasReumann/googlebooksapi.svg)](https://jitpack.io/#MatthiasReumann/googlebooksapi)

A wrapper of the [Google Books APIs](https://developers.google.com/books) written in Kotlin

## Usage

### Volumes
```kotlin 
val volumeHelper = VolumeHelper("API_KEY")
```

###### Get volumes

```kotlin
val request = VolumeGetRequest().apply {
    search("Plants")
    intitle("This is your mind on plants")
    inpublisher("Penguin")
    inauthor("Michael Pollan")
    langRestrict("en")
    maxResults(1)
    orderBy(SortOption.NEWEST)
    printType(PrintTypeOption.BOOKS)
    projection(ProjectionOption.LITE)
    startIndex(0)
}

val volumes: Volume = volumeHelper.get(request)
```

###### Get specific volume

```kotlin
val request = VolumeGetIDRequest().apply {
    volumeID("zKkdEAAAQBAJ")
    projection(ProjectionOption.LITE)
}

val volume: VolumeItem = volumeHelper.getVolumeWithID(request)
```

### Bookshelves

```kotlin
val bookshelfHelper = BookshelfHelper("API_KEY")
```

###### Get bookshelves

```kotlin
val request = BookshelfGetRequest().apply {
    userID("116445025672089480971")
    maxResults(1)
    startIndex(0)
}

val bookshelf: Bookshelf = bookshelfHelper.get(request)
```

###### Get specific bookshelf

```kotlin
val request = BookshelfGetIDRequest().apply {
    userID("116445025672089480971")
    bookshelfID(1001)
}

val item: BookshelfItem = bookshelfHelper.getBookshelfWithID(request)
```

###### Get volumes in bookshelf

```kotlin
val request = BookshelfGetVolumesRequest().apply {
    userID("116445025672089480971")
    bookshelfID(1001)
    maxResults(5)
    startIndex(0)
    projection(ProjectionOption.LITE)
}

val volumes: Volume = bookshelfHelper.getVolumesInBookshelf(request)
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

