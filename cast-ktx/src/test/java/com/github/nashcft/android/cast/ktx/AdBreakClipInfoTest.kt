package com.github.nashcft.android.cast.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class AdBreakClipInfoTest {

  @Test
  fun `AdBreakClipInfo builder works`() {
    val clipId = "testId"
    val clipContentId = "contentId"
    val clipContentUrl = "content url"
    val duration = 30_000L
    val adBreakClipInfo = adBreakClipInfo(clipId) {
      setContentId(clipContentId)
      setContentUrl(clipContentUrl)
      setDurationInMs(duration)
    }

    with(adBreakClipInfo) {
      assertThat(id).isEqualTo(clipId)
      assertThat(contentId).isEqualTo(clipContentId)
      assertThat(contentUrl).isEqualTo(clipContentUrl)
      assertThat(durationInMs).isEqualTo(duration)
    }
  }

  @Test
  fun `setVastAdsRequest with builder function works`() {
    val url = "url"
    val response = "response"
    val adBreakClipInfo = adBreakClipInfo("testId") {
      setVastAdsRequest {
        setAdTagUrl(url)
        setAdsResponse(response)
      }
    }

    with(adBreakClipInfo) {
      assertThat(vastAdsRequest?.adTagUrl).isEqualTo(url)
      assertThat(vastAdsRequest?.adsResponse).isEqualTo(response)
    }
  }
}
