package com.github.nashcft.android.cast.ktx

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.json.JSONObject
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MediaQueueItemTest {

  @Test
  fun `MediaQueueItem builder with MediaInfo works`() {
    val info = mediaInfo("test") {}
    val id = 100
    val duration = 60.0
    val item = mediaQueueItem(info) {
      setItemId(id)
      setPlaybackDuration(duration)
    }

    with(item) {
      assertThat(itemId).isEqualTo(id)
      assertThat(playbackDuration).isEqualTo(duration)
      assertThat(media).isEqualTo(info)
    }
  }

  @Test
  fun `MediaQueueItem builder with JsonObject works`() {
    val mediaInfoId = "media ID"
    val contentType = "video/mp4"
    val info = mediaInfo(mediaInfoId) {
      setContentType(contentType)
    }
    val json = JSONObject(
      """{
      |  "media": ${info.toJson()}
      |}""".trimMargin()
    )

    val id = 100
    val duration = 60.0
    val item = mediaQueueItem(json) {
      setItemId(id)
      setPlaybackDuration(duration)
    }

    with(item) {
      assertThat(itemId).isEqualTo(id)
      assertThat(playbackDuration).isEqualTo(duration)
      assertThat(media.contentId).isEqualTo(mediaInfoId)
      assertThat(media.contentType).isEqualTo(contentType)
    }
  }

  @Test
  fun `MediaQueueItem builder with another MediaQueueItem works`() {
    val info = mediaInfo("test") {}
    val id = 100
    val duration = 60.0
    val preload = 5.0
    val baseItem = mediaQueueItem(info) {
      setItemId(id)
      setPlaybackDuration(duration)
    }
    val item = mediaQueueItem(baseItem) {
      setAutoplay(true)
      setPreloadTime(preload)
    }

    with(item) {
      assertThat(itemId).isEqualTo(id)
      assertThat(playbackDuration).isEqualTo(duration)
      assertThat(media).isEqualTo(info)
      assertThat(autoplay).isTrue()
      assertThat(preloadTime).isEqualTo(preload)
    }
  }
}
