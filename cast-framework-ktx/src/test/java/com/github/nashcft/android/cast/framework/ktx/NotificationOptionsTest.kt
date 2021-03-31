package com.github.nashcft.android.cast.framework.ktx

import com.google.android.gms.cast.framework.media.MediaIntentReceiver
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NotificationOptionsTest {

  @Test
  fun `NotificationOptions builder works`() {
    val mediaIntentActions = listOf(
      MediaIntentReceiver.ACTION_FORWARD,
      MediaIntentReceiver.ACTION_REWIND,
      MediaIntentReceiver.ACTION_DISCONNECT
    )
    val indices = intArrayOf(0, 2)
    val activityName = "TestActivity"
    val skipStep = 30_000L
    val options = notificationOptions {
      setActions(mediaIntentActions, indices)
      setTargetActivityClassName(activityName)
      setSkipStepMs(skipStep)
    }

    with(options) {
      assertThat(actions).containsExactlyElementsIn(mediaIntentActions)
      assertThat(targetActivityClassName).isEqualTo(activityName)
      assertThat(skipStepMs).isEqualTo(skipStep)
    }
  }
}
