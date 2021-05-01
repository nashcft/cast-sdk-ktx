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

  api(Deps.castSdk)

  testImplementation(Deps.androidxTestCore)
  testImplementation(Deps.androidxJUnit)
  testImplementation(Deps.robolectric)
  testImplementation(Deps.truth)
}

extra.apply {
  set("releaseVersion", ProjectConfig.releaseVersion)
  set("releaseArtifactId", "cast-ktx")
  set("libraryDescription", "KTX library for Cast SDK (play-services-cast)")
}

apply(from = "../publish.gradle")
