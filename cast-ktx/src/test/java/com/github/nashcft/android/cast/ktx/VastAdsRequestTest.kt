package com.github.nashcft.android.cast.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class VastAdsRequestTest {

  @Test
  fun `VastAdRequest builder works`() {
    val url = "test url"
    val response = "test response"
    val vastAdsRequest = vastAdsRequest {
      setAdTagUrl(url)
      setAdsResponse(response)
    }

    with(vastAdsRequest) {
      assertThat(adTagUrl).isEqualTo(url)
      assertThat(adsResponse).isEqualTo(response)
    }
  }
}
