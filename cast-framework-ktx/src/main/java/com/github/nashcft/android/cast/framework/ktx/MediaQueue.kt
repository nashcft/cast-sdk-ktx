package com.github.nashcft.android.cast.framework.ktx

import com.github.nashcft.android.cast.framework.ktx.internal.awaitPendingResult
import com.google.android.gms.cast.framework.media.MediaQueue
import com.google.android.gms.cast.framework.media.RemoteMediaClient
import kotlinx.coroutines.suspendCancellableCoroutine

/**
 * Await the result of [MediaQueue.fetchMoreItemsRelativeToIndex] without blocking a thread.
 */
suspend fun MediaQueue.awaitFetchMoreItemsRelativeToIndex(
  index: Int,
  nextCount: Int,
  prevCount: Int
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  awaitPendingResult(it) { fetchMoreItemsRelativeToIndex(index, nextCount, prevCount) }
}
