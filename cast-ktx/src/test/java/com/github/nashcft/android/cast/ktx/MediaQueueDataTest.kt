package com.github.nashcft.android.cast.ktx

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaQueueDataTest {

  @Test
  fun `MediaQueueData builder works`() {
    val queueName = "test name"
    val queueEntity = "test entity"
    val data = mediaQueueData {
      setName(queueName)
      setEntity(queueEntity)
    }

    with(data) {
      assertThat(name).isEqualTo(queueName)
      assertThat(entity).isEqualTo(queueEntity)
    }
  }
}
