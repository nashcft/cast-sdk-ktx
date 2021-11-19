plugins {
  id("com.android.library")
  kotlin("android")
}

android {
  commonConfig()
}

dependencies {
  implementation(Deps.kotlinStdLib)
  implementation(Deps.kotlinStdLibJdk8)

  implementation(Deps.coroutinesCore)

  api(project(":cast-ktx"))
  api(Deps.castFrameworkSdk)

  testImplementation(Deps.androidxTestCore)
  testImplementation(Deps.androidxJUnit)
  testImplementation(Deps.truth)
  testImplementation(Deps.mockk)
}

mavenPublication(
  releaseArtifactId = "cast-framework-ktx",
  libraryDescription = "KTX library for Cast SDK (play-services-cast-framework)"
)
