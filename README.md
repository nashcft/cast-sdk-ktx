# Cast SDK Ktx

![CI](https://github.com/nashcft/cast-sdk-ktx/workflows/CI/badge.svg) [![JitPack](https://jitpack.io/v/nashcft/cast-sdk-ktx.svg)](https://jitpack.io/#nashcft/cast-sdk-ktx)


Kotlin extension libraries for [Google Cast SDK for Android](https://developers.google.com/cast/docs/reference/android/packages).

## Installation

Add JitPack repository to project's `repositories` block:

```kotlin
repositories {
  maven {
    url = uri("https://jitpack.io")
    content {
      includeGroup("com.github.nashcft.cast-sdk-ktx")
    }
  }
}
```

then replace each of Cast SDK dependencies with its ktx library.

```kotlin
dependencies {

  // for play-services-cast
  implementation("com.github.nashcft.cast-sdk-ktx:cast-ktx:$cast_sdk_ktx_version")
  
  // for play-services-cast-framework
  implementation("com.github.nashcft.cast-sdk-ktx:cast-framework-ktx:$cast_sdk_ktx_version")
  
  // for play-services-cast-tv
  implementation("com.github.nashcft.cast-sdk-ktx:cast-tv-ktx:$cast_sdk_ktx_version")
}
```
