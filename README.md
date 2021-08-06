# googlebooksapi
A Kotlin Wrapper of the [Google Books APIs](https://developers.google.com/books)

# Install

## Groovy
```
allprojects {
  repositories {
      maven { url "https://jitpack.io" }
  }
}

dependencies {
   implementation 'com.github.MatthiasReumann:googlebooksapi:master-SNAPSHOT'
}
```

## Kotlin DSL

```
allprojects {
  repositories {
    maven { url = uri("https://www.jitpack.io") }
  }
}

dependencies {
   implementation("com.github.MatthiasReumann:googlebooksapi:master-SNAPSHOT")
}
```

# Usage

## Volumes

```
suspend fun main() {
  val volumeHelper = VolumeHelper("API_KEY")
  volumeHelper.apply {
      inauthor("Michael Pollan")
      inpublisher("Penguin")
      intitle("This Is Your Mind On Plants")
      sorting(SortOption.NEWEST)
      printType(PrintTypeOption.BOOKS)
      projection(ProjectionOption.FULL)
      maxResults(3)
  }
  val volume = volumeHelper.get()
}
