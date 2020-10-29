package jp.nashcft.android.cast.framework.ktx

import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaLoadOptions
import com.google.android.gms.cast.MediaLoadRequestData
import com.google.android.gms.cast.framework.media.RemoteMediaClient
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

suspend fun RemoteMediaClient.awaitLoad(
  mediaInfo: MediaInfo,
  mediaLoadOptions: MediaLoadOptions
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine { cont ->
  val result = load(mediaInfo, mediaLoadOptions)
  cont.invokeOnCancellation { result.cancel() }
  result.setResultCallback { cont.resume(it) }
}

suspend fun RemoteMediaClient.awaitLoad(
  mediaLoadRequestData: MediaLoadRequestData
): RemoteMediaClient.MediaChannelResult = suspendCancellableCoroutine { cont ->
  val result = load(mediaLoadRequestData)
  cont.invokeOnCancellation { result.cancel() }
  result.setResultCallback { cont.resume(it) }
}
