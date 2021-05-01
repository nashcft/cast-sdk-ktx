plugins {
  id("com.android.library")
  kotlin("android")
}

android {
  compileSdkVersion(ProjectConfig.compileSdkVersion)

  defaultConfig {
    minSdkVersion(ProjectConfig.minSdkVersion)
    targetSdkVersion(ProjectConfig.targetSdkVersion)

    consumerProguardFiles("proguard-rules.pro")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  buildFeatures {
    buildConfig = false
  }

  testOptions.unitTests {
    isIncludeAndroidResources = true
    isReturnDefaultValues = true
  }
}

dependencies {
  implementation(Deps.kotlinStdLib)

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
