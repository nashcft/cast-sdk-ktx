package jp.nashcft.android.cast.ktx

import com.google.android.gms.cast.MediaSeekOptions
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaSeekOptionsTest {

  @Test
  fun `MediaSeekOptions builder works`() {
    val state = MediaSeekOptions.RESUME_STATE_PAUSE
    val seekPosition = 100_000L
    val options = mediaSeekOptions {
      setResumeState(state)
      setPosition(seekPosition)
      setIsSeekToInfinite(true)
    }

    with(options) {
      assertThat(resumeState).isEqualTo(state)
      assertThat(position).isEqualTo(seekPosition)
      assertThat(isSeekToInfinite).isTrue()
    }
  }
}
