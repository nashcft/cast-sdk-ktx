package jp.nashcft.android.cast.framework.ktx

import com.google.android.gms.common.api.PendingResult
import com.google.android.gms.common.api.Result
import com.google.android.gms.common.api.ResultCallback
import io.mockk.mockk
import java.util.concurrent.*

internal inline fun <reified T : Result> createMockPendingResult(): PendingResult<T> {
  return object : PendingResult<T>() {

    private val result: T = mockk()

    override fun await(): T = result

    override fun await(p0: Long, p1: TimeUnit): T = result

    override fun cancel() {
    }

    override fun isCanceled(): Boolean = false

    override fun setResultCallback(p0: ResultCallback<in T>) {
      p0.onResult(result)
    }

    override fun setResultCallback(p0: ResultCallback<in T>, p1: Long, p2: TimeUnit) {
      p0.onResult(result)
    }
  }
}
