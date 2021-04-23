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

  @Test
  fun `MediaLoadRequestData builder with MediaLoadRequestData instance works`() {
    val rate = 0.9
    val original = mediaLoadRequestData {
      setCredentials("test_original")
      setPlaybackRate(rate)
    }
    val testCredentials = "test_actual"
    val time = 12345L
    val actual = mediaLoadRequestData(original) {
      setCredentials(testCredentials)
      setCurrentTime(time)
    }

    with(actual) {
      assertThat(credentials).isEqualTo(testCredentials)
      assertThat(playbackRate).isEqualTo(rate)
      assertThat(currentTime).isEqualTo(time)
    }
  }
}
