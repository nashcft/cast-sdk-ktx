package jp.nashcft.android.cast.framework.ktx

import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.common.api.Status
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CastSessionTest {

  @Test
  fun awaitSendMessage(): Unit = runBlocking {
    val castSession = mockk<CastSession> {
      every { sendMessage(any(), any()) } returns createMockPendingResult<Status>()
    }

    val namespace = "testNamespace"
    val message = "test message"
    castSession.awaitSendMessage(namespace, message)

    verify { castSession.sendMessage(namespace, message) }
  }
}
