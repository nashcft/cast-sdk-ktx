package com.github.nashcft.android.cast.ktx

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.json.JSONObject
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SessionStateTest {

  @Test
  fun `SessionState builder works`() {
    val testCredentials = "test_credentials"
    val customDataKey = "foo"
    val customDataValue = "bar"
    val sessionState = sessionState {
      setLoadRequestData {
        setCredentials(testCredentials)
        setAutoplay(true)
      }
      setCustomData(JSONObject("""{ "$customDataKey": "$customDataValue" }"""))
    }

    with(sessionState) {
      assertThat(loadRequestData).isNotNull()
      assertThat(loadRequestData!!.credentials).isEqualTo(testCredentials)
      assertThat(loadRequestData!!.autoplay).isTrue()

      assertThat(customData).isNotNull()
      assertThat(customData!!.optString(customDataKey)).isEqualTo(customDataValue)
    }
  }
}
