package com.github.nashcft.android.cast.framework.ktx.internal

import com.google.android.gms.common.api.PendingResult
import com.google.android.gms.common.api.Result
import kotlinx.coroutines.CancellableContinuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

internal inline fun <T : Result> awaitPendingResult(
  cont: CancellableContinuation<T>,
  block: () -> PendingResult<T>
) {
  runCatching {
    val result = block()
    cont.invokeOnCancellation { result.cancel() }
    result.setResultCallback { cont.resume(it) }
  }.onFailure {
    cont.resumeWithException(it)
  }
}
