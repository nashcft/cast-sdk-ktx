package com.github.nashcft.android.cast.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LaunchOptionsTest {

  @Test
  fun `LaunchOptions builder works`() {
    val credentials = credentialsData("credentials")
    val options = launchOptions {
      setAndroidReceiverCompatible(true)
      setRelaunchIfRunning(true)
      setCredentialsData(credentials)
    }

    with(options) {
      assertThat(androidReceiverCompatible).isTrue()
      assertThat(relaunchIfRunning).isTrue()
      assertThat(credentialsData).isEqualTo(credentials)
    }
  }

  @Test
  fun `setCredentialsData with builder function works`() {
    val blob = "test blob"
    val options = launchOptions {
      setCredentialsData {
        setCredentials(blob)
      }
    }

    with(options) {
      assertThat(credentialsData.credentials).isEqualTo(blob)
    }
  }

  @Test
  fun `setCredentialsData with blob works`() {
    val blob = "blob"
    val options = launchOptions {
      setCredentialsData(blob)
    }

    with(options) {
      assertThat(credentialsData.credentials).isEqualTo(blob)
    }
  }
}
