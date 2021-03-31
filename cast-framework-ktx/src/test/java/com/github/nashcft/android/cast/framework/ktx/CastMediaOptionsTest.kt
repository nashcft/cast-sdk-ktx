package com.github.nashcft.android.cast.framework.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CastMediaOptionsTest {

  @Test
  fun `CastMediaOptions builder works`() {
    val activityName = "TestActivity"
    val receiverName = "TestReceiver"
    val options = castMediaOptions {
      setExpandedControllerActivityClassName(activityName)
      setMediaIntentReceiverClassName(receiverName)
      setMediaSessionEnabled(true)
    }

    with(options) {
      assertThat(expandedControllerActivityClassName).isEqualTo(activityName)
      assertThat(mediaIntentReceiverClassName).isEqualTo(receiverName)
      assertThat(mediaSessionEnabled).isTrue()
    }
  }

  @Test
  fun `setNotificationsOptions with scope function works`() {
    val activityName = "TargetActivity"
    val skipStep = 100_000L
    val options = castMediaOptions {
      setNotificationOptions {
        setTargetActivityClassName(activityName)
        setSkipStepMs(skipStep)
      }
    }

    with(options) {
      assertThat(notificationOptions.targetActivityClassName).isEqualTo(activityName)
      assertThat(notificationOptions.skipStepMs).isEqualTo(skipStep)
    }
  }
}
