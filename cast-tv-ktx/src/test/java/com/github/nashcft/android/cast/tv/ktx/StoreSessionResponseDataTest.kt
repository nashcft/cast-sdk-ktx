package com.github.nashcft.android.cast.tv.ktx

import com.google.android.gms.cast.MediaLoadRequestData
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import org.json.JSONObject
import org.junit.Test

class StoreSessionResponseDataTest {

  @Test
  fun `StoreSessionResponseData builder works`() {
    val customJSON = mockk<JSONObject>()
    val loadData = mockk<MediaLoadRequestData>()
    val responseData = storeSessionResponseData {
      setCustomData(customJSON)
      setSessionState {
        setLoadRequestData(loadData)
      }
    }

    with(responseData) {
      assertThat(customData).isEqualTo(customJSON)
      assertThat(sessionState.loadRequestData).isEqualTo(loadData)
    }
  }
}
