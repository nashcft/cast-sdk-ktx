package com.github.nashcft.android.cast.tv.ktx

import android.content.Context
import com.github.nashcft.android.cast.ktx.adBreakStatus
import com.github.nashcft.android.cast.ktx.mediaLiveSeekableRange
import com.github.nashcft.android.cast.ktx.mediaQueueData
import com.github.nashcft.android.cast.ktx.sessionState
import com.github.nashcft.android.cast.ktx.textTrackStyle
import com.github.nashcft.android.cast.ktx.vastAdsRequest
import com.github.nashcft.android.cast.ktx.videoInfo
import com.google.android.gms.cast.AdBreakStatus
import com.google.android.gms.cast.MediaLiveSeekableRange
import com.google.android.gms.cast.MediaQueueData
import com.google.android.gms.cast.SessionState
import com.google.android.gms.cast.TextTrackStyle
import com.google.android.gms.cast.VastAdsRequest
import com.google.android.gms.cast.VideoInfo
import com.google.android.gms.cast.tv.CastReceiverOptions
import com.google.android.gms.cast.tv.media.MediaInfoModifier
import com.google.android.gms.cast.tv.media.MediaManager
import com.google.android.gms.cast.tv.media.MediaMetadataModifier
import com.google.android.gms.cast.tv.media.MediaQueueManager
import com.google.android.gms.cast.tv.media.MediaStatusModifier
import com.google.android.gms.cast.tv.media.MediaTracksModifier
import com.google.android.gms.cast.tv.media.StoreSessionResponseData

/**
 * Create a [CastReceiverOptions] object.
 */
inline fun castReceiverOptions(
  context: Context,
  init: CastReceiverOptions.Builder.() -> Unit
): CastReceiverOptions = CastReceiverOptions.Builder(context).apply(init).build()

/**
 * Apply the specified function [block] to [MediaQueueManager].
 */
inline fun MediaManager.configureMediaQueueManager(
  block: MediaQueueManager.() -> Unit
) {
  mediaQueueManager.apply(block)
}

/**
 * Return [MediaQueueManager] to which the specified function [block] has been applied.
 */
inline fun MediaManager.getMediaQueueManagerWith(
  block: MediaQueueManager.() -> Unit
): MediaQueueManager = mediaQueueManager.apply(block)

/**
 * Apply the specified function [block] to [MediaStatusModifier].
 */
inline fun MediaManager.configureMediaStatusModifier(
  block: MediaStatusModifier.() -> Unit
) {
  mediaStatusModifier.apply(block)
}

/**
 * Return [MediaStatusModifier] to which the specified function [block] has been applied.
 */
inline fun MediaManager.getMediaStatusModifierWith(
  block: MediaStatusModifier.() -> Unit
): MediaStatusModifier = mediaStatusModifier.apply(block)

/**
 * Set [MediaQueueData] created from the [builder] function.
 */
inline fun MediaQueueManager.setMediaQueueData(
  builder: MediaQueueData.Builder.() -> Unit
): MediaQueueManager = setMediaQueueData(mediaQueueData(builder))

/**
 * Apply the specified function [block] to [MediaTracksModifier].
 */
inline fun MediaStatusModifier.configureMediaTracksModifier(
  block: MediaTracksModifier.() -> Unit
) {
  mediaTracksModifier.apply(block)
}

/**
 * Return [MediaTracksModifier] to which the specified function [block] has been applied.
 */
inline fun MediaStatusModifier.getMediaTracksModifierWith(
  block: MediaTracksModifier.() -> Unit
): MediaTracksModifier = mediaTracksModifier.apply(block)

/**
 * Set [AdBreakStatus] created from the [builder] function.
 */
inline fun MediaStatusModifier.setAdBreakStatus(
  builder: AdBreakStatus.Builder.() -> Unit
): MediaStatusModifier = setAdBreakStatus(adBreakStatus(builder))

/**
 * Set [MediaLiveSeekableRange] created from the [builder] function.
 */
inline fun MediaStatusModifier.setLiveSeekableRange(
  builder: MediaLiveSeekableRange.Builder.() -> Unit
): MediaStatusModifier = setLiveSeekableRange(mediaLiveSeekableRange(builder))

/**
 * Set [MediaInfoModifier] created from the [builder] function.
 */
inline fun MediaStatusModifier.setMediaInfoModifier(
  builder: MediaInfoModifier.() -> Unit
) {
  mediaInfoModifier = MediaInfoModifier().apply(builder)
}

/**
 * Set [VideoInfo] created from the [builder] function.
 */
inline fun MediaStatusModifier.setVideoInfo(
  builder: VideoInfo.Builder.() -> Unit
): MediaStatusModifier = setVideoInfo(videoInfo(builder))

/**
 * Set [MediaMetadataModifier] created from the [builder] function.
 */
inline fun MediaInfoModifier.setMetadataModifier(
  builder: MediaMetadataModifier.() -> Unit
) {
  setMetadataModifier(MediaMetadataModifier().apply(builder))
}

/**
 * Set [TextTrackStyle] created from the [builder] function.
 */
inline fun MediaInfoModifier.setTextTrackStyle(
  builder: TextTrackStyle.() -> Unit
): MediaInfoModifier = setTextTrackStyle(textTrackStyle(builder))

/**
 * Set [VastAdsRequest] created from the [builder] function.
 */
inline fun MediaInfoModifier.setVmapAdsRequest(
  builder: VastAdsRequest.Builder.() -> Unit
): MediaInfoModifier = setVmapAdsRequest(vastAdsRequest(builder))

/**
 * Create a [StoreSessionResponseData] object.
 */
inline fun storeSessionResponseData(
  init: StoreSessionResponseData.Builder.() -> Unit
): StoreSessionResponseData = StoreSessionResponseData.Builder().apply(init).build()

/**
 * Set [SessionState] created from the [builder] function.
 */
inline fun StoreSessionResponseData.Builder.setSessionState(
  builder: SessionState.Builder.() -> Unit
) {
  setSessionState(sessionState(builder))
}
