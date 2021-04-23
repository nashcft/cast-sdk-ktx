package com.github.nashcft.android.cast.ktx

import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaMetadata
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaInfoTest {

  @Test
  fun `MediaInfo builder with contentId works`() {
    val mediaContentId = "content ID"
    val mediaContentUrl = "test url"
    val mediaStreamType = MediaInfo.STREAM_TYPE_BUFFERED
    val info = mediaInfo(mediaContentId) {
      setContentUrl(mediaContentUrl)
      setStreamType(mediaStreamType)
    }

    with(info) {
      assertThat(contentId).isEqualTo(mediaContentId)
      assertThat(contentUrl).isEqualTo(mediaContentUrl)
      assertThat(streamType).isEqualTo(mediaStreamType)
    }
  }

  @Test
  fun `MediaInfo  builder with  contentId and entity works`() {
    val mediaContentId = "content ID"
    val mediaEntity = "test entity"
    val mediaContentType = "video/mp4"
    val mediaMetadata = MediaMetadata(MediaMetadata.MEDIA_TYPE_MOVIE)
    val info = mediaInfo(mediaContentId, mediaEntity) {
      setContentType(mediaContentType)
      setMetadata(mediaMetadata)
    }

    with(info) {
      assertThat(contentId).isEqualTo(mediaContentId)
      assertThat(entity).isEqualTo(mediaEntity)
      assertThat(contentType).isEqualTo(mediaContentType)
      assertThat(metadata).isEqualTo(mediaMetadata)
    }
  }

  @Test
  fun `setVmapAdsRequest with builder function works`() {
    val url = "test url"
    val info = mediaInfo("ID") {
      setVmapAdsRequest {
        setAdTagUrl(url)
      }
    }

    with(info) {
      assertThat(vmapAdsRequest?.adTagUrl).isEqualTo(url)
    }
  }
}
