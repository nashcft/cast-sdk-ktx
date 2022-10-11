plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
}

@Suppress("UnstableApiUsage")
android {
  compileSdk = 33

  defaultConfig {
    minSdk = 19
    targetSdk = 33

    consumerProguardFiles("proguard-rules.pro")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }

  buildFeatures {
    buildConfig = false
  }

  testOptions.unitTests {
    isIncludeAndroidResources = true
    isReturnDefaultValues = true
  }
}
