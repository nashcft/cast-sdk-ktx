package com.github.nashcft.android.cast.framework.ktx

import com.google.android.gms.cast.framework.media.MediaQueue
import com.google.android.gms.cast.framework.media.RemoteMediaClient
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test

class MediaQueueTest {

  @Test
  fun awaitFetchMoreItemsRelativeToIndex(): Unit = runBlocking {
    val mediaQueue = mockk<MediaQueue> {
      every {
        fetchMoreItemsRelativeToIndex(any(), any(), any())
      } returns createMockPendingResult<RemoteMediaClient.MediaChannelResult>()
    }

    mediaQueue.awaitFetchMoreItemsRelativeToIndex(1, 2, 3)

    verify { mediaQueue.fetchMoreItemsRelativeToIndex(1, 2, 3) }
  }
}
