import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath(Deps.androidGradlePlugin)
    classpath(Deps.kotlinPlugin)
  }
}

allprojects {
  tasks.withType<KotlinCompile>().all {
    kotlinOptions {
      jvmTarget = "1.8"
    }
  }
}
