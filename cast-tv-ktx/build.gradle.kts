plugins {
  id("com.android.library")
  kotlin("android")
  id("maven-publish")
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

  api(project(":cast-ktx"))
  api(Deps.castTvSdk)

  testImplementation(Deps.androidxTestCore)
  testImplementation(Deps.androidxJUnit)
  testImplementation(Deps.robolectric)
  testImplementation(Deps.truth)
  testImplementation(Deps.mockk)
}

extra.apply {
  set("releaseVersion", ProjectConfig.releaseVersion)
  set("releaseArtifactId", "cast-tv-ktx")
  set("libraryDescription", "KTX library for Cast SDK (play-services-cast-tv)")
}

apply(from = "../publish.gradle")
