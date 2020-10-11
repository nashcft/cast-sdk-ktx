package jp.nashcft.android.cast.ktx

import com.google.android.gms.cast.MediaTrack
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaTrackTest {

  @Test
  fun `MediaTrack builder works`() {
    val trackId = 10L
    val trackType = MediaTrack.TYPE_TEXT
    val trackName = "test name"
    val trackSubType = MediaTrack.SUBTYPE_SUBTITLES
    val track = mediaTrack(trackId, trackType) {
      setName(trackName)
      setSubtype(trackSubType)
    }

    with(track) {
      assertThat(id).isEqualTo(trackId)
      assertThat(type).isEqualTo(trackType)
      assertThat(name).isEqualTo(trackName)
      assertThat(subtype).isEqualTo(trackSubType)
    }
  }
}
