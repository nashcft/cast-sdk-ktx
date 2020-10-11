package jp.nashcft.android.cast.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class AdBreakInfoTest {

  @Test
  fun `AdBreakInfo builder works`() {
    val playbackPosition = 100_000L
    val clipIds = arrayOf("ID1", "ID2", "ID3")
    val adBreakInfo = adBreakInfo(playbackPosition) {
      setBreakClipIds(clipIds)
      setIsEmbedded(true)
      setIsWatched(true)
    }

    with(adBreakInfo) {
      assertThat(playbackPositionInMs).isEqualTo(playbackPosition)
      assertThat(breakClipIds).isEqualTo(clipIds)
      assertThat(isEmbedded).isTrue()
      assertThat(isWatched).isTrue()
    }
  }
}
