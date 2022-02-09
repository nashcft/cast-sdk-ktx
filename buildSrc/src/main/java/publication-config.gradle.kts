plugins {
  `maven-publish`
}

class PublicationExtension {

  fun mavenPublication(
    releaseArtifactId: String,
    libraryDescription: String,
  ) {
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
