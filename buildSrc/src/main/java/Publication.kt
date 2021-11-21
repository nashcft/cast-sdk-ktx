import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get

fun Project.mavenPublication(
  releaseArtifactId: String,
  libraryDescription: String,
) {
  apply<MavenPublishPlugin>()
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

private fun Project.publishing(configure: Action<PublishingExtension>) =
  (this as ExtensionAware).extensions.configure("publishing", configure)
