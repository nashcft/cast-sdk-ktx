plugins {
  id("com.android.library")
  kotlin("android")
}

android {
  commonConfig()
}

dependencies {
  implementation(Deps.kotlinStdLib)

  api(project(":cast-ktx"))
  api(Deps.castTvSdk)

  testImplementation(Deps.androidxTestCore)
  testImplementation(Deps.androidxJUnit)
  testImplementation(Deps.robolectric)
  testImplementation(Deps.truth)
  testImplementation(Deps.mockk)
}

mavenPublication(
  releaseArtifactId = "cast-tv-ktx",
  libraryDescription = "KTX library for Cast SDK (play-services-cast-tv)"
)
