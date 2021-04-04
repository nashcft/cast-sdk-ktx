package com.github.nashcft.android.cast.tv.ktx

import com.google.android.gms.cast.MediaMetadata
import com.google.android.gms.cast.TextTrackStyle
import com.google.android.gms.cast.tv.media.MediaInfoModifier
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaInfoModifierTest {

  @Test
  fun `MediaMetadataModifier setter with builder function works`() {
    val type = MediaMetadata.MEDIA_TYPE_MOVIE
    val stringKey = "test_string_key"
    val stringValue = "test value"
    val intKey = "test_int_key"
    val intValue = 123
    val mediaInfoModifier = MediaInfoModifier()
    mediaInfoModifier.setMetadataModifier {
      mediaType = type
      putString(stringKey, stringValue)
      putInt(intKey, intValue)
    }
    with(mediaInfoModifier.metadataModifier!!) {
      assertThat(mediaType).isEqualTo(type)
      assertThat(hasOverrideForKey(stringKey)).isTrue()
      assertThat(getString(stringKey)).isEqualTo(stringValue)
      assertThat(hasOverrideForKey(intKey)).isTrue()
      assertThat(getInt(intKey)).isEqualTo(intValue)
      assertThat(hasOverrideForKey("key_not_set")).isFalse()
    }
  }

  @Test
  fun `TextTrackStyle setter with builder function works`() {
    val scale = 1.1F
    val edge = TextTrackStyle.EDGE_TYPE_RAISED
    val mediaInfoModifier = MediaInfoModifier().setTextTrackStyle {
      fontScale = scale
      edgeType = edge
    }
    with(mediaInfoModifier.textTrackStyle!!) {
      assertThat(fontScale).isEqualTo(scale)
      assertThat(edgeType).isEqualTo(edge)
    }
  }

  @Test
  fun `VastAdsRequest setter with builder function works`() {
    val url = "https://test.url"
    val response = "test ads response"
    val mediaInfoModifier = MediaInfoModifier().setVmapAdsRequest {
      setAdTagUrl(url)
      setAdsResponse(response)
    }
    with(mediaInfoModifier.vmapAdsRequest!!) {
      assertThat(adTagUrl).isEqualTo(url)
      assertThat(adsResponse).isEqualTo(response)
    }
  }
}
