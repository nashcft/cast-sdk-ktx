package com.github.nashcft.android.cast.ktx

import com.google.android.gms.cast.CredentialsData
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CredentialsDataTest {

  @Test
  fun `CredentialsData builder works`() {
    val blob = "test credentials"
    val credentialsData = credentialsData {
      setCredentials(blob)
      setCredentialsType(CredentialsData.CREDENTIALS_TYPE_CLOUD)
    }

    with(credentialsData) {
      assertThat(credentials).isEqualTo(blob)
      assertThat(credentialsType).isEqualTo(CredentialsData.CREDENTIALS_TYPE_CLOUD)
    }
  }

  @Test
  fun `CredentialsData of default credentials type builder works`() {
    val blob = "test blob"
    val credentialsData = credentialsData(blob)

    with(credentialsData) {
      assertThat(credentials).isEqualTo(blob)
      assertThat(credentialsType).isEqualTo(CredentialsData.CREDENTIALS_TYPE_ANDROID)
    }
  }
}
