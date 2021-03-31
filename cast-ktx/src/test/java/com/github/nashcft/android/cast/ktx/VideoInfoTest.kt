package com.github.nashcft.android.cast.ktx

import com.google.android.gms.cast.VideoInfo
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class VideoInfoTest {

  @Test
  fun `VideoInfo builder works`() {
    val type = VideoInfo.HDR_TYPE_HDR10
    val h = 2160
    val w = 3840
    val info = videoInfo {
      setHdrType(type)
      setHeight(h)
      setWidth(w)
    }

    with(info) {
      assertThat(hdrType).isEqualTo(type)
      assertThat(height).isEqualTo(h)
      assertThat(width).isEqualTo(w)
    }
  }
}
