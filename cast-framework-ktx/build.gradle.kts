plugins {
  id("android-config")
  id("publication-config")
}

dependencies {
  implementation(libs.kotlin.stdlib)

  implementation(libs.kotlinx.coroutines.core)

  api(project(":cast-ktx"))
  api(libs.cast.framework)

  testImplementation(libs.androidx.test.core)
  testImplementation(libs.androidx.test.junit)
  testImplementation(libs.truth)
  testImplementation(libs.mockk)
}

publicationConfig.mavenPublication(
  releaseArtifactId = "cast-framework-ktx",
  libraryDescription = "KTX library for Cast SDK (play-services-cast-framework)"
)
