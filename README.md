# googlebooksapi
A Kotlin Wrapper of the Google Books APIs

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


