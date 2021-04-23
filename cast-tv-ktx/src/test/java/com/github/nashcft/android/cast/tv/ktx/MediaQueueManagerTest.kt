package com.github.nashcft.android.cast.tv.ktx

import com.google.android.gms.cast.tv.media.MediaQueueManager
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import org.junit.Test

class MediaQueueManagerTest {

  @Test
  fun `MediaQueueData setter with builder function works`() {
    val queueName = "queue name"
    val id = "queue ID"
    val mediaQueueManager = MediaQueueManager(mockk())
    mediaQueueManager.setMediaQueueData {
      setName(queueName)
      setQueueId(id)
    }

    val mediaQueueData =
      mediaQueueManager.mediaQueueData ?: error("getMediaQueueData() returns null")
    with(mediaQueueData) {
      assertThat(name).isEqualTo(queueName)
      assertThat(queueId).isEqualTo(id)
    }
  }
}
