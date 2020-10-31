package jp.nashcft.android.cast.framework.ktx

import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaLoadOptions
import com.google.android.gms.cast.MediaLoadRequestData
import com.google.android.gms.cast.MediaQueueItem
import com.google.android.gms.cast.MediaSeekOptions
import com.google.android.gms.cast.TextTrackStyle
import com.google.android.gms.cast.framework.media.RemoteMediaClient
import com.google.android.gms.common.api.PendingResult
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import org.json.JSONObject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Await the result of [RemoteMediaClient.load] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitLoad(
  mediaInfo: MediaInfo,
  mediaLoadOptions: MediaLoadOptions
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { load(mediaInfo, mediaLoadOptions) }
}

/**
 * Await the result of [RemoteMediaClient.load] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitLoad(
  mediaLoadRequestData: MediaLoadRequestData
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { load(mediaLoadRequestData) }
}


/**
 * Await the result of [RemoteMediaClient.pause] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitPause(
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { pause(customData) }
}

/**
 * Await the result of [RemoteMediaClient.play] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitPlay(
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { play(customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueAppendItem] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueAppendItem(
  item: MediaQueueItem,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueAppendItem(item, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueInsertAndPlayItem] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueInsertAndPlayItem(
  item: MediaQueueItem,
  insertBeforeItemId: Int,
  playPosition: Long = -1L,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueInsertAndPlayItem(item, insertBeforeItemId, playPosition, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueInsertItems] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueInsertItems(
  itemsToInsert: Array<MediaQueueItem>,
  insertBeforeItemId: Int,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueInsertItems(itemsToInsert, insertBeforeItemId, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueInsertItems] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueInsertItems(
  itemsToInsert: Collection<MediaQueueItem>,
  insertBeforeItemId: Int,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueInsertItems(itemsToInsert.toTypedArray(), insertBeforeItemId, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueJumpToItem] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueJumpToItem(
  itemId: Int,
  playPosition: Long = -1L,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueJumpToItem(itemId, playPosition, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueLoad] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueLoad(
  items: Array<MediaQueueItem>,
  startIndex: Int,
  repeatMode: Int,
  playPosition: Long = -1L,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueLoad(items, startIndex, repeatMode, playPosition, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueLoad] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueLoad(
  items: Collection<MediaQueueItem>,
  startIndex: Int,
  repeatMode: Int,
  playPosition: Long = -1L,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueLoad(items.toTypedArray(), startIndex, repeatMode, playPosition, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueMoveItemToNewIndex] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueMoveItemToNewIndex(
  itemId: Int,
  newIndex: Int,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueMoveItemToNewIndex(itemId, newIndex, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueNext] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueNext(
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueNext(customData) }
}

/**
 * Await the result of [RemoteMediaClient.queuePrev] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueuePrev(
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queuePrev(customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueRemoveItem] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueRemoveItem(
  itemId: Int,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueRemoveItem(itemId, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueRemoveItems] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueRemoveItems(
  itemIdsToRemove: IntArray,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueRemoveItems(itemIdsToRemove, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueRemoveItems] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueRemoveItems(
  itemIdsToRemove: Collection<Int>,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueRemoveItems(itemIdsToRemove.toIntArray(), customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueReorderItems] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueReorderItems(
  itemIdsToReorder: IntArray,
  insertBeforeItemId: Int,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueReorderItems(itemIdsToReorder, insertBeforeItemId, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueReorderItems] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueReorderItems(
  itemIdsToReorder: Collection<Int>,
  insertBeforeItemId: Int,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueReorderItems(itemIdsToReorder.toIntArray(), insertBeforeItemId, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueSetRepeatMode] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueSetRepeatMode(
  repeatMode: Int,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueSetRepeatMode(repeatMode, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueUpdateItems] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueUpdateItems(
  itemsToUpdate: Array<MediaQueueItem>,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueUpdateItems(itemsToUpdate, customData) }
}

/**
 * Await the result of [RemoteMediaClient.queueUpdateItems] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitQueueUpdateItems(
  itemsToUpdate: Collection<MediaQueueItem>,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { queueUpdateItems(itemsToUpdate.toTypedArray(), customData) }
}

/**
 * Await the result of [RemoteMediaClient.requestStatus] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitRequestStatus(): RemoteMediaClient.MediaChannelResult =
  suspendCancellableCoroutine {
    execute(it) { requestStatus() }
  }

/**
 * Await the result of [RemoteMediaClient.seek] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitSeek(
  seekOptions: MediaSeekOptions
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { seek(seekOptions) }
}

/**
 * Await the result of [RemoteMediaClient.setActiveMediaTracks] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitSetActiveMediaTracks(
  trackIds: LongArray
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { setActiveMediaTracks(trackIds) }
}

/**
 * Await the result of [RemoteMediaClient.setActiveMediaTracks] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitSetActiveMediaTracks(
  trackIds: Collection<Long>
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { setActiveMediaTracks(trackIds.toLongArray()) }
}

/**
 * Await the result of [RemoteMediaClient.setPlaybackRate] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitSetPlaybackRate(
  playbackRate: Double,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { setPlaybackRate(playbackRate, customData) }
}

/**
 * Await the result of [RemoteMediaClient.setStreamMute] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitSetStreamMute(
  muted: Boolean,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { setStreamMute(muted, customData) }
}

/**
 * Await the result of [RemoteMediaClient.setStreamVolume] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitSetStreamVolume(
  volume: Double,
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { setStreamVolume(volume, customData) }
}

/**
 * Await the result of [RemoteMediaClient.setTextTrackStyle] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitSetTextTrackStyle(
  trackStyle: TextTrackStyle
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { setTextTrackStyle(trackStyle) }
}

/**
 * Await the result of [RemoteMediaClient.skipAd] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitSkipAd(): RemoteMediaClient.MediaChannelResult =
  suspendCancellableCoroutine {
    execute(it) { skipAd() }
  }

/**
 * Await the result of [RemoteMediaClient.stop] without blocking a thread.
 */
suspend fun RemoteMediaClient.awaitStop(
  customData: JSONObject? = null
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine {
  execute(it) { stop(customData) }
}

private inline fun execute(
  cont: CancellableContinuation<RemoteMediaClient.MediaChannelResult>,
  block: () -> PendingResult<RemoteMediaClient.MediaChannelResult>
) {
  runCatching {
    val result = block()
    cont.invokeOnCancellation { result.cancel() }
    result.setResultCallback { cont.resume(it) }
  }.onFailure {
    cont.resumeWithException(it)
  }
}
