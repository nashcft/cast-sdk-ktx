package com.github.nashcft.android.cast.tv.ktx

import com.google.android.gms.cast.VideoInfo
import com.google.android.gms.cast.tv.media.MediaStatusModifier
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaStatusModifierTest {

  @Test
  fun `AdBreakStatus setter with builder function works`() {
    val id = "ad break id"
    val currentBreakClipTime = 1_000L
    val currentBreakTime = 10_000L
    val mediaStatusModifier = MediaStatusModifier().setAdBreakStatus {
      setBreakId(id)
      setCurrentBreakClipTimeInMs(currentBreakClipTime)
      setCurrentBreakTimeInMs(currentBreakTime)
    }
    with(mediaStatusModifier.adBreakStatus!!) {
      assertThat(breakId).isEqualTo(id)
      assertThat(currentBreakClipTimeInMs).isEqualTo(currentBreakClipTime)
      assertThat(currentBreakTimeInMs).isEqualTo(currentBreakTime)
    }
  }

  @Test
  fun `MediaLiveSeekableRange setter with builder function works`() {
    val start = 100L
    val end = 5_000L
    val mediaStatusModifier = MediaStatusModifier().setLiveSeekableRange {
      setStartTime(start)
      setEndTime(end)
    }
    with(mediaStatusModifier.liveSeekableRange!!) {
      assertThat(startTime).isEqualTo(start)
      assertThat(endTime).isEqualTo(end)
    }
  }

  @Test
  fun `MediaInfoModifier setter with builder function works`() {
    val id = "content ID"
    val type = "content type"
    val duration = 50_000L
    val mediaStatusModifier = MediaStatusModifier().apply {
      setMediaInfoModifier {
        contentId = id
        contentType = type
        streamDuration = duration
      }
    }
    with(mediaStatusModifier.mediaInfoModifier!!) {
      assertThat(contentId).isEqualTo(id)
      assertThat(contentType).isEqualTo(type)
      assertThat(streamDuration).isEqualTo(duration)
    }
  }

  @Test
  fun `VideoInfo setter with builder function works`() {
    val type = VideoInfo.HDR_TYPE_HDR
    val h = 1080
    val w = 1920
    val mediaStatusModifier = MediaStatusModifier().setVideoInfo {
      setHdrType(type)
      setHeight(h)
      setWidth(w)
    }
    with(mediaStatusModifier.videoInfo!!) {
      assertThat(hdrType).isEqualTo(type)
      assertThat(height).isEqualTo(h)
      assertThat(width).isEqualTo(w)
    }
  }

  @Test
  fun `configureMediaTracksModifier applies the specified changes properly`() {
    val activeTracks = longArrayOf(1, 2, 5)
    val mediaStatusModifier = MediaStatusModifier()
    mediaStatusModifier.configureMediaTracksModifier {
      setActiveTrackIds(activeTracks)
    }

    with(mediaStatusModifier.mediaTracksModifier) {
      assertThat(activeTrackIds).containsExactlyElementsIn(activeTrackIds)
    }
  }
}
