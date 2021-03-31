package com.github.nashcft.android.cast.ktx

import com.google.android.gms.cast.MediaError
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaErrorTest {

  @Test
  fun `MediaError builder works`() {
    val errorType = MediaError.ERROR_TYPE_LOAD_FAILED
    val errorReason = MediaError.ERROR_REASON_NOT_SUPPORTED
    val mediaError = mediaError {
      setType(errorType)
      setReason(errorReason)
    }

    with(mediaError) {
      assertThat(type).isEqualTo(errorType)
      assertThat(reason).isEqualTo(errorReason)
    }
  }
}
