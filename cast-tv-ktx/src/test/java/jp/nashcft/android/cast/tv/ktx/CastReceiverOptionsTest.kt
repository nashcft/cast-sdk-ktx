package jp.nashcft.android.cast.tv.ktx

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CastReceiverOptionsTest {

  private val context: Context
    get() = ApplicationProvider.getApplicationContext()

  @Test
  fun `CastReceiverOptions builder works`() {
    val namespaces = listOf("namespace 1", "namespace 2", "namespace 3")
    val status = "test status"
    val options = castReceiverOptions(context) {
      setCustomNamespaces(namespaces)
      setStatusText(status)
    }

    with(options) {
      assertThat(customNamespaces).containsExactlyElementsIn(namespaces)
      assertThat(statusText).isEqualTo(status)
    }
  }
}
