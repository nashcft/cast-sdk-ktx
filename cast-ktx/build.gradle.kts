plugins {
  id("com.android.library")
  kotlin("android")
}

android {
  commonConfig()
}

dependencies {
  implementation(Deps.kotlinStdLib)

  api(Deps.castSdk)

  testImplementation(Deps.androidxTestCore)
  testImplementation(Deps.androidxJUnit)
  testImplementation(Deps.robolectric)
  testImplementation(Deps.truth)
}

mavenPublication(
  releaseArtifactId = "cast-ktx",
  libraryDescription = "KTX library for Cast SDK (play-services-cast)"
)
