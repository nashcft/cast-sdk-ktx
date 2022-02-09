plugins {
  id("android-config")
  id("publication-config")
}

dependencies {
  implementation(libs.kotlin.stdlib)

  api(project(":cast-ktx"))
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
