plugins {
  `maven-publish`
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
}

private object PublicationConfig {
  const val releaseVersion = "0.6.0-SNAPSHOT"
  const val groupId = "com.github.nashcft.cast-sdk-ktx"

  const val license = "The Apache License, Version 2.0"
  const val licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0.txt"

  const val developerId = "nashcft"
  const val developerName = "Nagahori Shota"

  const val siteUrl = "https://github.com/nashcft/cast-sdk-ktx"
  const val connection = "scm:git:git://github.com/nashcft/cast-sdk-ktx.git"
  const val developerConnection = "scm:git:ssh://git@github.com/nashcft/cast-sdk-ktx.git"

  const val publishingComponentName_release = "release"
}

class PublicationExtension {

  fun mavenPublication(
    releaseArtifactId: String,
    libraryDescription: String,
  ) {
    android.publishing {
      singleVariant(PublicationConfig.publishingComponentName_release) {
        withSourcesJar()
        withJavadocJar()
      }
    }
    afterEvaluate {
      publishing {
        publications {
          create<MavenPublication>(PublicationConfig.publishingComponentName_release) {
            from(components[PublicationConfig.publishingComponentName_release])
            groupId = PublicationConfig.groupId
            artifactId = releaseArtifactId
            version = PublicationConfig.releaseVersion

            pom {
              name.set(releaseArtifactId)
              description.set(libraryDescription)
              url.set(PublicationConfig.siteUrl)

              licenses {
                license {
                  name.set(PublicationConfig.license)
                  url.set(PublicationConfig.licenseUrl)
                }
              }
              developers {
                developer {
                  id.set(PublicationConfig.developerId)
                  name.set(PublicationConfig.developerName)
                }
              }
              scm {
                connection.set(PublicationConfig.connection)
                developerConnection.set(PublicationConfig.developerConnection)
                url.set(PublicationConfig.siteUrl)
              }
            }
          }
        }
      }
    }
  }
}

extensions.add("publicationConfig", PublicationExtension())
