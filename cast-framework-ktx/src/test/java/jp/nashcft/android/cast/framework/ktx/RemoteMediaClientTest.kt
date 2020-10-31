package jp.nashcft.android.cast.framework.ktx

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaLoadOptions
import com.google.android.gms.cast.MediaLoadRequestData
import com.google.android.gms.cast.MediaQueueItem
import com.google.android.gms.cast.MediaSeekOptions
import com.google.android.gms.cast.MediaStatus
import com.google.android.gms.cast.TextTrackStyle
import com.google.android.gms.cast.framework.media.RemoteMediaClient
import com.google.android.gms.common.api.PendingResult
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
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
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { load(any() as MediaLoadRequestData) } returns mockPendingResult
    }

    val mediaLoadRequestData = mockk<MediaLoadRequestData>()
    remoteMediaClient.awaitLoad(mediaLoadRequestData)

    verify { remoteMediaClient.load(mediaLoadRequestData) }
  }

  @Test
  fun `awaitLoad with MediaLoadRequestData throws an exception`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { load(any() as MediaLoadRequestData) } throws IllegalStateException("error!!")
    }

    try {
      remoteMediaClient.awaitLoad(mockk())
      error("should not be reached here")
    } catch (th: Throwable) {
      assertThat(th).hasMessageThat().isEqualTo("error!!")
    }
  }

  @Test
  fun `awaitLoad with MediaInfo and MediaLoadOptions`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every {
        load(
          any() as MediaInfo,
          any() as MediaLoadOptions
        )
      } returns mockPendingResult
    }

    val mediaInfo = mockk<MediaInfo>()
    val mediaLoadOptions = mockk<MediaLoadOptions>()
    remoteMediaClient.awaitLoad(mediaInfo, mediaLoadOptions)

    verify { remoteMediaClient.load(mediaInfo, mediaLoadOptions) }
  }

  @Test
  fun awaitPause(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { pause(any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitPause()

    verify { remoteMediaClient.pause(null) }
  }

  @Test
  fun awaitPlay(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { play(any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitPlay(null)

    verify { remoteMediaClient.play(null) }
  }

  @Test
  fun awaitQueueAppendItem(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueAppendItem(any(), any()) } returns mockPendingResult
    }

    val item = mockk<MediaQueueItem>()
    val customData = JSONObject("""{}""")
    remoteMediaClient.awaitQueueAppendItem(item, customData)

    verify { remoteMediaClient.queueAppendItem(item, customData) }
  }

  @Test
  fun awaitQueueInsertAndPlayItem(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every {
        queueInsertAndPlayItem(
          any(),
          any(),
          any(),
          any()
        )
      } returns mockPendingResult
    }

    val item = mockk<MediaQueueItem>()
    remoteMediaClient.awaitQueueInsertAndPlayItem(item, 10)

    verify { remoteMediaClient.queueInsertAndPlayItem(item, 10, -1L, null) }
  }

  @Test
  fun `awaitQueueInsertItems with an array of MediaQueueItem`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueInsertItems(any(), any(), any()) } returns mockPendingResult
    }

    val items = arrayOf<MediaQueueItem>(mockk(), mockk(), mockk())
    remoteMediaClient.awaitQueueInsertItems(items, 10)

    verify { remoteMediaClient.queueInsertItems(items, 10, null) }
  }

  @Test
  fun `awaitQueueInsertItems with a collection of MediaQueueItem`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueInsertItems(any(), any(), any()) } returns mockPendingResult
    }

    val items = listOf<MediaQueueItem>(mockk(), mockk())
    remoteMediaClient.awaitQueueInsertItems(items, 20)
    verify { remoteMediaClient.queueInsertItems(items.toTypedArray(), 20, null) }
  }

  @Test
  fun awaitQueueJumpToItem(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueJumpToItem(any(), any(), any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitQueueJumpToItem(10)

    verify { remoteMediaClient.queueJumpToItem(10, -1L, null) }
  }

  @Test
  fun `awaitQueueLoad with an array of MediaQueueItem`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueLoad(any(), any(), any(), any(), any()) } returns mockPendingResult
    }

    val items = arrayOf<MediaQueueItem>(mockk(), mockk(), mockk())
    remoteMediaClient.awaitQueueLoad(items, 1, MediaStatus.REPEAT_MODE_REPEAT_ALL)

    verify { remoteMediaClient.queueLoad(items, 1, MediaStatus.REPEAT_MODE_REPEAT_ALL, -1L, null) }
  }

  @Test
  fun `awaitQueueLoad with a collection of MediaQueueItem`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueLoad(any(), any(), any(), any(), any()) } returns mockPendingResult
    }

    val items = listOf<MediaQueueItem>(mockk(), mockk(), mockk())
    remoteMediaClient.awaitQueueLoad(items, 2, MediaStatus.REPEAT_MODE_REPEAT_OFF)

    verify {
      remoteMediaClient.queueLoad(
        items.toTypedArray(),
        2,
        MediaStatus.REPEAT_MODE_REPEAT_OFF,
        -1L,
        null
      )
    }
  }

  @Test
  fun awaitQueueMoveItemToNewIndex(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueMoveItemToNewIndex(any(), any(), any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitQueueMoveItemToNewIndex(11, 2)

    verify { remoteMediaClient.queueMoveItemToNewIndex(11, 2, null) }
  }

  @Test
  fun awaitQueueNext(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueNext(any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitQueueNext()

    verify { remoteMediaClient.queueNext(null) }
  }

  @Test
  fun awaitQueuePrev(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queuePrev(any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitQueuePrev()

    verify { remoteMediaClient.queuePrev(null) }
  }

  @Test
  fun awaitQueueRemoveItem(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueRemoveItem(any(), any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitQueueRemoveItem(0)

    verify { remoteMediaClient.queueRemoveItem(0, null) }
  }

  @Test
  fun `awaitQueueRemoveItems with an array of item IDs`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueRemoveItems(any(), any()) } returns mockPendingResult
    }

    val itemIds = intArrayOf(1, 3, 5)
    remoteMediaClient.awaitQueueRemoveItems(itemIds)

    verify { remoteMediaClient.queueRemoveItems(itemIds, null) }
  }

  @Test
  fun `awaitQueueRemoveItems with a collection of item IDs`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueRemoveItems(any(), any()) } returns mockPendingResult
    }

    val itemIds = listOf(2, 4, 6)
    remoteMediaClient.awaitQueueRemoveItems(itemIds)

    verify { remoteMediaClient.queueRemoveItems(itemIds.toIntArray(), null) }
  }

  @Test
  fun `awaitQueueReorderItems with an array of item IDs`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueReorderItems(any(), any(), any()) } returns mockPendingResult
    }

    val itemIds = intArrayOf(1, 3, 5)
    remoteMediaClient.awaitQueueReorderItems(itemIds, 1)

    verify { remoteMediaClient.queueReorderItems(itemIds, 1, null) }
  }

  @Test
  fun `awaitQueueReorderItems with a collection of item IDs`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueReorderItems(any(), any(), any()) } returns mockPendingResult
    }

    val itemIds = listOf(2, 4, 6)
    remoteMediaClient.awaitQueueReorderItems(itemIds, 0)

    verify { remoteMediaClient.queueReorderItems(itemIds.toIntArray(), 0, null) }
  }

  @Test
  fun awaitQueueSetRepeatMode(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueSetRepeatMode(any(), any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitQueueSetRepeatMode(MediaStatus.REPEAT_MODE_REPEAT_SINGLE)

    verify { remoteMediaClient.queueSetRepeatMode(MediaStatus.REPEAT_MODE_REPEAT_SINGLE, null) }
  }

  @Test
  fun `awaitQueueUpdateItems with an array of MediaQueueItems`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueUpdateItems(any(), any()) } returns mockPendingResult
    }

    val items = arrayOf<MediaQueueItem>(mockk(), mockk())
    remoteMediaClient.awaitQueueUpdateItems(items)

    verify { remoteMediaClient.queueUpdateItems(items, null) }
  }

  @Test
  fun `awaitQueueUpdateItems with a collection of MediaQueueItems`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { queueUpdateItems(any(), any()) } returns mockPendingResult
    }

    val items = listOf<MediaQueueItem>(mockk(), mockk())
    remoteMediaClient.awaitQueueUpdateItems(items)

    verify { remoteMediaClient.queueUpdateItems(items.toTypedArray(), null) }
  }

  @Test
  fun awaitRequestStatus(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { requestStatus() } returns mockPendingResult
    }

    remoteMediaClient.awaitRequestStatus()

    verify { remoteMediaClient.requestStatus() }
  }

  @Test
  fun awaitSeek(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { seek(any() as MediaSeekOptions) } returns mockPendingResult
    }

    val seekOptions = mockk<MediaSeekOptions>()
    remoteMediaClient.awaitSeek(seekOptions)

    verify { remoteMediaClient.seek(seekOptions) }
  }

  @Test
  fun `awaitSetActiveMediaTracks with an array of track IDs`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { setActiveMediaTracks(any()) } returns mockPendingResult
    }

    val trackIds = longArrayOf(1, 2, 3)
    remoteMediaClient.awaitSetActiveMediaTracks(trackIds)

    verify { remoteMediaClient.setActiveMediaTracks(trackIds) }
  }

  @Test
  fun `awaitSetActiveMediaTracks with a collection of track IDs`(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { setActiveMediaTracks(any()) } returns mockPendingResult
    }

    val trackIds = listOf(1L, 2L, 3L)
    remoteMediaClient.awaitSetActiveMediaTracks(trackIds)

    verify { remoteMediaClient.setActiveMediaTracks(trackIds.toLongArray()) }
  }

  @Test
  fun awaitSetPlaybackRate(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { setPlaybackRate(any(), any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitSetPlaybackRate(0.5)

    verify { remoteMediaClient.setPlaybackRate(0.5, null) }
  }

  @Test
  fun awaitSetStreamMute(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { setStreamMute(any(), any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitSetStreamMute(false)

    verify { remoteMediaClient.setStreamMute(false, null) }

    remoteMediaClient.awaitSetStreamMute(true)

    verify { remoteMediaClient.setStreamMute(true, null) }
  }

  @Test
  fun awaitSetStreamVolume(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { setStreamVolume(any(), any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitSetStreamVolume(0.75)

    verify { remoteMediaClient.setStreamVolume(0.75, null) }
  }

  @Test
  fun awaitSetTextTrackStyle(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { setTextTrackStyle(any()) } returns mockPendingResult
    }

    val trackStyle = mockk<TextTrackStyle>()
    remoteMediaClient.awaitSetTextTrackStyle(trackStyle)

    verify { remoteMediaClient.setTextTrackStyle(trackStyle) }
  }

  @Test
  fun awaitSkipAd(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { skipAd() } returns mockPendingResult
    }

    remoteMediaClient.awaitSkipAd()

    verify { remoteMediaClient.skipAd() }
  }

  @Test
  fun awaitStop(): Unit = runBlocking {
    val remoteMediaClient = mockk<RemoteMediaClient> {
      every { stop(any()) } returns mockPendingResult
    }

    remoteMediaClient.awaitStop()

    verify { remoteMediaClient.stop(null) }
  }

  private val mockPendingResult = object : PendingResult<RemoteMediaClient.MediaChannelResult>() {

    private val result = mockk<RemoteMediaClient.MediaChannelResult> {
      every { customData } returns JSONObject("""{ "test": "test ok" }""")
      every { status } returns Status(com.google.android.gms.common.api.CommonStatusCodes.SUCCESS)
      every { mediaError } returns mediaError { }
    }

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
}
