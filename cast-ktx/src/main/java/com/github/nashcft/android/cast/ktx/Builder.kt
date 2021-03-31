package com.github.nashcft.android.cast.ktx

import com.google.android.gms.cast.AdBreakClipInfo
import com.google.android.gms.cast.AdBreakInfo
import com.google.android.gms.cast.AdBreakStatus
import com.google.android.gms.cast.Cast
import com.google.android.gms.cast.CastDevice
import com.google.android.gms.cast.CastRemoteDisplayLocalService
import com.google.android.gms.cast.CredentialsData
import com.google.android.gms.cast.LaunchOptions
import com.google.android.gms.cast.MediaError
import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaLiveSeekableRange
import com.google.android.gms.cast.MediaLoadOptions
import com.google.android.gms.cast.MediaLoadRequestData
import com.google.android.gms.cast.MediaQueueContainerMetadata
import com.google.android.gms.cast.MediaQueueData
import com.google.android.gms.cast.MediaQueueItem
import com.google.android.gms.cast.MediaSeekOptions
import com.google.android.gms.cast.MediaTrack
import com.google.android.gms.cast.VastAdsRequest
import com.google.android.gms.cast.VideoInfo
import org.json.JSONObject

/**
 * Create an [AdBreakClipInfo] object.
 */
inline fun adBreakClipInfo(
  id: String,
  init: AdBreakClipInfo.Builder.() -> Unit
): AdBreakClipInfo = AdBreakClipInfo.Builder(id).apply(init).build()

/**
 * Set [VastAdsRequest] created from the [builder] function.
 */
inline fun AdBreakClipInfo.Builder.setVastAdsRequest(builder: VastAdsRequest.Builder.() -> Unit) {
  setVastAdsRequest(vastAdsRequest(builder))
}

/**
 * Create an [AdBreakInfo] object.
 */
inline fun adBreakInfo(
  playbackPositionInMs: Long,
  init: AdBreakInfo.Builder.() -> Unit
): AdBreakInfo = AdBreakInfo.Builder(playbackPositionInMs).apply(init).build()

/**
 * Create an [AdBreakStatus] object.
 */
inline fun adBreakStatus(init: AdBreakStatus.Builder.() -> Unit): AdBreakStatus =
  AdBreakStatus.Builder().apply(init).build()

/**
 * Create a [Cast.CastOptions] object.
 */
inline fun castOptions(
  castDevice: CastDevice,
  listener: Cast.Listener,
  init: Cast.CastOptions.Builder.() -> Unit = {}
): Cast.CastOptions = Cast.CastOptions.Builder(castDevice, listener).apply(init).build()

/**
 * Create a [CastRemoteDisplayLocalService.NotificationSettings] object.
 */
inline fun notificationSettings(
  init: CastRemoteDisplayLocalService.NotificationSettings.Builder.() -> Unit
): CastRemoteDisplayLocalService.NotificationSettings =
  CastRemoteDisplayLocalService.NotificationSettings.Builder().apply(init).build()

/**
 * Create a [CredentialsData] object initialized using [init] function.
 */
inline fun credentialsData(init: CredentialsData.Builder.() -> Unit): CredentialsData =
  CredentialsData.Builder().apply(init).build()

/**
 * Create a [CredentialsData] object initialized with [credentials] and default credentials type.
 */
fun credentialsData(credentials: String): CredentialsData = credentialsData {
  setCredentials(credentials)
}

/**
 * Create a [LaunchOptions] object.
 */
inline fun launchOptions(init: LaunchOptions.Builder.() -> Unit): LaunchOptions =
  LaunchOptions.Builder().apply(init).build()

/**
 * Set [CredentialsData] created from the [builder] function.
 */
inline fun LaunchOptions.Builder.setCredentialsData(builder: CredentialsData.Builder.() -> Unit) {
  setCredentialsData(credentialsData(builder))
}

/**
 * Set [CredentialsData] with [credentials].
 */
fun LaunchOptions.Builder.setCredentialsData(credentials: String) {
  setCredentialsData(credentialsData(credentials))
}

/**
 * Create a [MediaError] object.
 */
inline fun mediaError(init: MediaError.Builder.() -> Unit): MediaError =
  MediaError.Builder().apply(init).build()

/**
 * Create [MediaInfo] initialized with [contentId] and using the [init] function.
 */
inline fun mediaInfo(
  contentId: String,
  init: MediaInfo.Builder.() -> Unit
): MediaInfo = MediaInfo.Builder(contentId).apply(init).build()

/**
 * Create [MediaInfo] initialized with [contentId] and [entity], and using the [init] function.
 */
inline fun mediaInfo(
  contentId: String,
  entity: String,
  init: MediaInfo.Builder.() -> Unit
): MediaInfo = MediaInfo.Builder(contentId, entity).apply(init).build()

/**
 * Set [VastAdsRequest] from the [builder] function.
 */
inline fun MediaInfo.Builder.setVmapAdsRequest(builder: VastAdsRequest.Builder.() -> Unit) {
  setVmapAdsRequest(vastAdsRequest(builder))
}

/**
 * Create a [MediaLiveSeekableRange] object.
 */
inline fun mediaLiveSeekableRange(
  init: MediaLiveSeekableRange.Builder.() -> Unit
): MediaLiveSeekableRange = MediaLiveSeekableRange.Builder().apply(init).build()

/**
 * Create a [MediaLoadOptions] object.
 */
inline fun mediaLoadOptions(init: MediaLoadOptions.Builder.() -> Unit): MediaLoadOptions =
  MediaLoadOptions.Builder().apply(init).build()

/**
 * Create a [MediaLoadRequestData] object.
 */
inline fun mediaLoadRequestData(init: MediaLoadRequestData.Builder.() -> Unit): MediaLoadRequestData =
  MediaLoadRequestData.Builder().apply(init).build()

/**
 * Create a [MediaQueueContainerMetadata] object.
 */
inline fun mediaQueueContainerMetadata(
  init: MediaQueueContainerMetadata.Builder.() -> Unit
): MediaQueueContainerMetadata = MediaQueueContainerMetadata.Builder().apply(init).build()

/**
 * Create a [MediaQueueData] object.
 */
inline fun mediaQueueData(init: MediaQueueData.Builder.() -> Unit): MediaQueueData =
  MediaQueueData.Builder().apply(init).build()

/**
 * Create a [MediaQueueItem] object initialized with [mediaInfo] and using the [init] function.
 */
inline fun mediaQueueItem(
  mediaInfo: MediaInfo,
  init: MediaQueueItem.Builder.() -> Unit
): MediaQueueItem = MediaQueueItem.Builder(mediaInfo).apply(init).build()

/**
 * Create a [MediaQueueItem] object initialized with [jsonObject] and using the [init] function.
 */
inline fun mediaQueueItem(
  jsonObject: JSONObject,
  init: MediaQueueItem.Builder.() -> Unit = {}
): MediaQueueItem = MediaQueueItem.Builder(jsonObject).apply(init).build()

/**
 * Create a [MediaQueueItem] object initialized with [mediaQueueItem] and using the [init] function.
 */
inline fun mediaQueueItem(
  mediaQueueItem: MediaQueueItem,
  init: MediaQueueItem.Builder.() -> Unit = {}
): MediaQueueItem = MediaQueueItem.Builder(mediaQueueItem).apply(init).build()

/**
 * Create a [MediaSeekOptions] object.
 */
inline fun mediaSeekOptions(init: MediaSeekOptions.Builder.() -> Unit): MediaSeekOptions =
  MediaSeekOptions.Builder().apply(init).build()

/**
 * Create a [MediaTrack] object.
 */
inline fun mediaTrack(
  trackId: Long,
  trackType: Int,
  init: MediaTrack.Builder.() -> Unit
): MediaTrack = MediaTrack.Builder(trackId, trackType).apply(init).build()

/**
 * Create a [VastAdsRequest] object.
 */
inline fun vastAdsRequest(init: VastAdsRequest.Builder.() -> Unit): VastAdsRequest =
  VastAdsRequest.Builder().apply(init).build()

/**
 * Create a [VideoInfo] object.
 */
inline fun videoInfo(init: VideoInfo.Builder.() -> Unit): VideoInfo =
  VideoInfo.Builder().apply(init).build()
