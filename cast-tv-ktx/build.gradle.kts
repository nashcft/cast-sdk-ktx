plugins {
  id("android-config")
  id("publication-config")
}

android {
  namespace = "com.github.nashcft.android.cast.tv.ktx"
}

dependencies {
  implementation(libs.kotlin.stdlib)

  api(projects.castKtx)
  api(libs.cast.tv)

  testImplementation(libs.androidx.test.core)
  testImplementation(libs.androidx.test.junit)
  testImplementation(libs.robolectric)
  testImplementation(libs.truth)
  testImplementation(libs.mockk)
}

publicationConfig.mavenPublication(
  releaseArtifactId = "cast-tv-ktx",
  libraryDescription = "KTX library for Cast SDK (play-services-cast-tv)"
)
