package com.github.nashcft.android.cast.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaLoadOptionsTest {

  @Test
  fun `MediaLoadOptions builder works`() {
    val trackIds = longArrayOf(1, 2, 3)
    val options = mediaLoadOptions {
      setAutoplay(true)
      setActiveTrackIds(trackIds)
    }

    with(options) {
      assertThat(autoplay).isTrue()
      assertThat(activeTrackIds).isEqualTo(trackIds)
    }
  }
}
