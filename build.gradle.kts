// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
    jcenter()
  }
  dependencies {
    classpath(Deps.androidGradlePlugin)
    classpath(Deps.kotlinPlugin)

    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
  }
}

allprojects {
  repositories {
    google()
    jcenter()
  }

  tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
    kotlinOptions {
      jvmTarget = "1.8"
    }
  }
}
