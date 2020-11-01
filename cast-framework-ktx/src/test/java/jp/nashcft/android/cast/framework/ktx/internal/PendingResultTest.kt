package jp.nashcft.android.cast.framework.ktx.internal

import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.PendingResult
import com.google.android.gms.common.api.Result
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import org.junit.Test
import java.util.concurrent.*

class PendingResultTest {

  @Test
  fun `when the given continuation is successfully resumed`(): Unit = runBlocking {
    val result = suspendCancellableCoroutine<Result> {
      awaitPendingResult(it) {
        object : PendingResult<Result>() {

          private val result = Result { Status(CommonStatusCodes.SUCCESS) }

          override fun await(): Result = result

          override fun await(p0: Long, p1: TimeUnit): Result = result

          override fun cancel() {
          }

          override fun isCanceled(): Boolean = false

          override fun setResultCallback(p0: ResultCallback<in Result>) {
            p0.onResult(result)
          }

          override fun setResultCallback(
            p0: ResultCallback<in Result>,
            p1: Long,
            p2: TimeUnit
          ) {
          }
        }
      }
    }

    assertThat(result.status.statusCode).isEqualTo(CommonStatusCodes.SUCCESS)
  }

  @Test(expected = IllegalStateException::class)
  fun `when the given block throws an exception`(): Unit = runBlocking {
    suspendCancellableCoroutine<Result> {
      awaitPendingResult(it) { throw IllegalStateException("error") }
    }
    error("Should not be reached here")
  }

  @Test
  fun `when the given continuation has been cancelled before resume`(): Unit = runBlocking {
    var called = false
    try {
      suspendCancellableCoroutine<Result> { cont ->
        awaitPendingResult(cont) {
          object : PendingResult<Result>() {

            private var result = Result { Status(CommonStatusCodes.SUCCESS) }

            override fun await(): Result = result

            override fun await(p0: Long, p1: TimeUnit): Result = result

            override fun cancel() {
              called = true
            }

            override fun isCanceled(): Boolean = false

            override fun setResultCallback(p0: ResultCallback<in Result>) {
              cont.cancel()
            }

            override fun setResultCallback(
              p0: ResultCallback<in Result>,
              p1: Long,
              p2: TimeUnit
            ) {
            }
          }
        }
      }
    } catch (th: Throwable) {
      assertThat(th).isInstanceOf(CancellationException::class.java)
      assertThat(called).isTrue()
    }
  }
}
