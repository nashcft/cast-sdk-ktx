package com.github.nashcft.android.cast.tv.ktx

import android.content.Context
import com.github.nashcft.android.cast.ktx.adBreakStatus
import com.github.nashcft.android.cast.ktx.mediaLiveSeekableRange
import com.github.nashcft.android.cast.ktx.mediaLoadRequestData
import com.github.nashcft.android.cast.ktx.mediaQueueData
import com.github.nashcft.android.cast.ktx.videoInfo
import com.google.android.gms.cast.AdBreakStatus
import com.google.android.gms.cast.MediaLiveSeekableRange
import com.google.android.gms.cast.MediaLoadRequestData
import com.google.android.gms.cast.MediaQueueData
import com.google.android.gms.cast.VideoInfo
import com.google.android.gms.cast.tv.CastReceiverOptions
import com.google.android.gms.cast.tv.media.MediaInfoModifier
import com.google.android.gms.cast.tv.media.MediaManager
import com.google.android.gms.cast.tv.media.MediaQueueManager
import com.google.android.gms.cast.tv.media.MediaStatusModifier
import com.google.android.gms.cast.tv.media.MediaTracksModifier

/**
 * Create a [CastReceiverOptions] object.
 */
inline fun castReceiverOptions(
  context: Context,
  init: CastReceiverOptions.Builder.() -> Unit
): CastReceiverOptions = CastReceiverOptions.Builder(context).apply(init).build()

/**
 * Set [MediaLoadRequestData] created from the [builder] function.
 */
inline fun MediaManager.setDataFromLoad(builder: MediaLoadRequestData.Builder.() -> Unit) {
  setDataFromLoad(mediaLoadRequestData(builder))
}

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

// TODO: MediaInfoModifier, MediaTracksModifier
