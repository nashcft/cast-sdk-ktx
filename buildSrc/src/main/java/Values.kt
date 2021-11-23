object ProjectConfig {
  const val compileSdkVersion = 31
  const val targetSdkVersion = 31
  const val minSdkVersion = 19
}

internal object PublicationConfig {
  const val releaseVersion = "0.4.0-SNAPSHOT"
  const val groupId = "com.github.nashcft.cast-sdk-ktx"

  const val license = "The Apache License, Version 2.0"
  const val licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0.txt"

  const val developerId = "nashcft"
  const val developerName = "Nagahori Shota"

  const val siteUrl = "https://github.com/nashcft/cast-sdk-ktx"
  const val connection = "scm:git:git://github.com/nashcft/cast-sdk-ktx.git"
  const val developerConnection = "scm:git:ssh://git@github.com/nashcft/cast-sdk-ktx.git"
}

object Deps {

  const val androidGradlePlugin = "com.android.tools.build:gradle:7.1.0-beta03"

  private const val kotlinVersion = "1.6.0"
  const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
  const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
  const val kotlinStdLibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"

  const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"

  const val castSdk = "com.google.android.gms:play-services-cast:20.1.0"
  const val castFrameworkSdk = "com.google.android.gms:play-services-cast-framework:20.1.0"
  const val castTvSdk = "com.google.android.gms:play-services-cast-tv:18.0.0"

  const val androidxTestCore = "androidx.test:core-ktx:1.4.0"
  const val androidxJUnit = "androidx.test.ext:junit-ktx:1.1.3"
  const val robolectric = "org.robolectric:robolectric:4.7.1"

  const val truth = "com.google.truth:truth:1.1.3"
  const val mockk = "io.mockk:mockk:1.12.1"
}
