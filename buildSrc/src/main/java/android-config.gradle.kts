plugins {
  id("com.android.library")
  kotlin("android")
}

@Suppress("UnstableApiUsage")
android {
  compileSdk = ProjectConfig.compileSdkVersion

  defaultConfig {
    minSdk = ProjectConfig.minSdkVersion
    targetSdk = ProjectConfig.targetSdkVersion

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

  publishing {
    singleVariant(PublicationConfig.publishingComponentName_release) {
      withSourcesJar()
      withJavadocJar()
    }
  }
}
