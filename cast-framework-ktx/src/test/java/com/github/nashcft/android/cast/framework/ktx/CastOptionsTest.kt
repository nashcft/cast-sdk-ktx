package com.github.nashcft.android.cast.framework.ktx

import com.github.nashcft.android.cast.ktx.credentialsData
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CastOptionsTest {

  @Test
  fun `CastOptions builder works`() {
    val appId = "testAppId"
    val options = castOptions {
      setReceiverApplicationId(appId)
      setEnableReconnectionService(true)
      setResumeSavedSession(false)
    }

    with(options) {
      assertThat(receiverApplicationId).isEqualTo(appId)
      assertThat(enableReconnectionService).isTrue()
      assertThat(resumeSavedSession).isFalse()
    }
  }

  @Test
  fun `setCastMediaOptions with builder function works`() {
    val activityName = "TestActivity"
    val receiverName = "TestReceiver"
    val options = castOptions {
      setCastMediaOptions {
        setExpandedControllerActivityClassName(activityName)
        setMediaIntentReceiverClassName(receiverName)
      }
    }

    with(options) {
      assertThat(castMediaOptions.expandedControllerActivityClassName).isEqualTo(activityName)
      assertThat(castMediaOptions.mediaIntentReceiverClassName).isEqualTo(receiverName)
    }
  }

  @Test
  fun `setLaunchOptions with builder function works`() {
    val credentialsData = credentialsData("credentials")
    val options = castOptions {
      setLaunchOptions {
        setAndroidReceiverCompatible(true)
        setCredentialsData(credentialsData)
      }
    }

    with(options) {
      assertThat(launchOptions.androidReceiverCompatible).isTrue()
      assertThat(launchOptions.credentialsData).isEqualTo(credentialsData)
    }
  }
}
