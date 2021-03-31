package com.github.nashcft.android.cast.framework.ktx

import com.github.nashcft.android.cast.framework.ktx.internal.awaitPendingResult
import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.common.api.Status
import kotlinx.coroutines.suspendCancellableCoroutine

/**
 * Await the result of [CastSession.sendMessage] without blocking a thread.
 */
suspend fun CastSession.awaitSendMessage(
  namespace: String,
  message: String
): Status = suspendCancellableCoroutine {
  awaitPendingResult(it) { sendMessage(namespace, message) }
}
