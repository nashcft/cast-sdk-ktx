package com.github.nashcft.android.cast.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaLiveSeekableRangeTest {

  @Test
  fun `MediaLiveSeekableRange builder works`() {
    val start = 1_000L
    val end = 100_000L
    val range = mediaLiveSeekableRange {
      setStartTime(start)
      setEndTime(end)
    }

    with(range) {
      assertThat(startTime).isEqualTo(start)
      assertThat(endTime).isEqualTo(end)
    }
  }
}
