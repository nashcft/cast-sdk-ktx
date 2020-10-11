package jp.nashcft.android.cast.ktx

import com.google.android.gms.cast.MediaMetadata
import com.google.android.gms.cast.MediaQueueContainerMetadata
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MediaQueueContainerMetadataTest {

  @Test
  fun `MediaQueueContainerMetadata builder works`() {
    val metadataTitle = "test title"
    val type = MediaQueueContainerMetadata.MEDIA_QUEUE_CONTAINER_TYPE_GENERIC
    val list = listOf(MediaMetadata(), MediaMetadata(MediaMetadata.MEDIA_TYPE_MOVIE))
    val metaDada = mediaQueueContainerMetadata {
      setTitle(metadataTitle)
      setContainerType(type)
      setSections(list)
    }

    with(metaDada) {
      assertThat(title).isEqualTo(metadataTitle)
      assertThat(containerType).isEqualTo(type)
      assertThat(sections).containsExactlyElementsIn(list)
    }
  }
}
