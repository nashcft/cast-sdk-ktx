plugins {
  `kotlin-dsl`
}

repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation(kotlin("gradle-plugin"))
  implementation("com.android.tools.build:gradle:7.1.1")
}
