plugins {
  id("android-config")
  id("publication-config")
}

dependencies {
  implementation(libs.kotlin.stdlib)

  api(libs.cast)

  testImplementation(libs.androidx.test.core)
  testImplementation(libs.androidx.test.junit)
  testImplementation(libs.robolectric)
  testImplementation(libs.truth)
}

publicationConfig.mavenPublication(
  releaseArtifactId = "cast-ktx",
  libraryDescription = "KTX library for Cast SDK (play-services-cast)"
)
