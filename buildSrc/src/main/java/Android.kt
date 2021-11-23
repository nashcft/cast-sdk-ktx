import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

@Suppress("UnstableApiUsage")
fun LibraryExtension.commonConfig() {
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

@Suppress("UnstableApiUsage")
private fun LibraryExtension.kotlinOptions(configure: Action<KotlinJvmOptions>) =
  (this as ExtensionAware).extensions.configure("kotlinOptions", configure)

