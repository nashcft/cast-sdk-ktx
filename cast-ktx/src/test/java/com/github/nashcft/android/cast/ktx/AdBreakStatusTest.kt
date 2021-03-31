package com.github.nashcft.android.cast.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class AdBreakStatusTest {

  @Test
  fun `AdBreakStatus builder works`() {
    val currentBreakClipTime = 1_000L
    val currentBreakTime = 10_000L
    val whenSkippable = 5_000L
    val adBreakStatus = adBreakStatus {
      setCurrentBreakClipTimeInMs(currentBreakClipTime)
      setCurrentBreakTimeInMs(currentBreakTime)
      setWhenSkippableInMs(whenSkippable)
    }

    with(adBreakStatus) {
      assertThat(currentBreakClipTimeInMs).isEqualTo(currentBreakClipTime)
      assertThat(currentBreakTimeInMs).isEqualTo(currentBreakTime)
      assertThat(whenSkippableInMs).isEqualTo(whenSkippable)
    }
  }
}
