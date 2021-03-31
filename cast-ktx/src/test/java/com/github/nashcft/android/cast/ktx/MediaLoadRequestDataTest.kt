package com.github.nashcft.android.cast.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaLoadRequestDataTest {

  @Test
  fun `MediaLoadRequestData builder works`() {
    val testCredentials = "test"
    val rate = 0.5
    val data = mediaLoadRequestData {
      setCredentials(testCredentials)
      setPlaybackRate(rate)
    }

    with(data) {
      assertThat(credentials).isEqualTo(testCredentials)
      assertThat(playbackRate).isEqualTo(rate)
    }
  }
}
