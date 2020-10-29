package jp.nashcft.android.cast.framework.ktx

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaLoadOptions
import com.google.android.gms.cast.MediaLoadRequestData
import com.google.android.gms.cast.framework.media.RemoteMediaClient
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.PendingResult
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import jp.nashcft.android.cast.ktx.mediaError
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.*

@RunWith(AndroidJUnit4::class)
class RemoteMediaClientTest {

  @Test
  fun `awaitLoad with MediaLoadRequestData`(): Unit = runBlocking {
    val customData = """{ "test1": "test1 ok" }"""
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { load(any() as MediaLoadRequestData) } returns createSuccessPendingResult(customData)
    }

    val result = remoteMediaClient.awaitLoad(mockk())

    assertThat(result.customData.getString("test1")).isEqualTo("test1 ok")
  }

  @Test
  fun `awaitLoad with MediaInfo and MediaLoadOptions`(): Unit = runBlocking {
    val customData = """{ "test2": "test2 ok" }"""
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every {
        load(
          any() as MediaInfo,
          any() as MediaLoadOptions
        )
      } returns createSuccessPendingResult(customData)
    }

    val result = remoteMediaClient.awaitLoad(mockk(), mockk())

    assertThat(result.customData.getString("test2")).isEqualTo("test2 ok")
  }

  private fun createSuccessPendingResult(customData: String): PendingResult<RemoteMediaClient.MediaChannelResult> =
    object : PendingResult<RemoteMediaClient.MediaChannelResult>() {

      private val result = createSuccessResult(JSONObject(customData))
      override fun await(): RemoteMediaClient.MediaChannelResult = result

      override fun await(p0: Long, p1: TimeUnit): RemoteMediaClient.MediaChannelResult = result

      override fun cancel() {
      }

      override fun isCanceled(): Boolean = false

      override fun setResultCallback(p0: ResultCallback<in RemoteMediaClient.MediaChannelResult>) {
        p0.onResult(result)
      }

      override fun setResultCallback(
        p0: ResultCallback<in RemoteMediaClient.MediaChannelResult>,
        p1: Long,
        p2: TimeUnit
      ) {
        p0.onResult(result)
      }
    }

  private fun createSuccessResult(mockData: JSONObject): RemoteMediaClient.MediaChannelResult =
    mockk {
      every { customData } returns mockData
      every { status } returns Status(CommonStatusCodes.SUCCESS)
      every { mediaError } returns mediaError { }
    }
}
