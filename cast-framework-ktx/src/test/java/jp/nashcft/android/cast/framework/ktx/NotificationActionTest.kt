package jp.nashcft.android.cast.framework.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NotificationActionTest {

  @Test
  fun `NotificationAction builder works`() {
    val intentAction = "test action"
    val description = "test"
    val notificationAction = notificationAction {
      setAction(intentAction)
      setContentDescription(description)
    }

    with(notificationAction) {
      assertThat(action).isEqualTo(intentAction)
      assertThat(contentDescription).isEqualTo(description)
    }
  }
}
