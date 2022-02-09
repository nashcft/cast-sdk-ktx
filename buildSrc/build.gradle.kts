plugins {
  `kotlin-dsl`
}

repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation(libs.kotlin.plugin)
  implementation(libs.android.gradle.plugin)
}
