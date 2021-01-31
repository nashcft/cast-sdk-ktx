object ProjectConfig {
  const val compileSdkVersion = 30
  const val targetSdkVersion = 30
  const val minSdkVersion = 19
}

object Deps {

  const val androidGradlePlugin = "com.android.tools.build:gradle:4.2.0-beta04"

  private const val kotlinVersion = "1.4.21"
  const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
  const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"

  private const val coroutinesVersion = "1.4.2"
  const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"

  const val castSdk = "com.google.android.gms:play-services-cast:19.0.0"
  const val castFrameworkSdk = "com.google.android.gms:play-services-cast-framework:19.0.0"
  const val castTvSdk = "com.google.android.gms:play-services-cast-tv:17.0.0"

  const val androidxTestCore = "androidx.test:core-ktx:1.3.0"
  const val androidxJUnit = "androidx.test.ext:junit-ktx:1.1.2"
  const val robolectric = "org.robolectric:robolectric:4.5"

  const val truth = "com.google.truth:truth:1.1.2"
  const val mockk = "io.mockk:mockk:1.10.5"
}
