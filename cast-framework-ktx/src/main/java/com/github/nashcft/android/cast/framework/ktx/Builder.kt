package com.github.nashcft.android.cast.framework.ktx

import android.app.Activity
import android.view.MenuItem
import androidx.mediarouter.app.MediaRouteButton
import com.github.nashcft.android.cast.ktx.launchOptions
import com.google.android.gms.cast.LaunchOptions
import com.google.android.gms.cast.framework.CastOptions
import com.google.android.gms.cast.framework.IntroductoryOverlay
import com.google.android.gms.cast.framework.media.CastMediaOptions
import com.google.android.gms.cast.framework.media.NotificationAction
import com.google.android.gms.cast.framework.media.NotificationOptions

/**
 * Create a [CastOptions] object.
 */
inline fun castOptions(init: CastOptions.Builder.() -> Unit): CastOptions =
  CastOptions.Builder().apply(init).build()

/**
 * Set [CastMediaOptions] created from the [builder] function.
 */
inline fun CastOptions.Builder.setCastMediaOptions(builder: CastMediaOptions.Builder.() -> Unit) {
  setCastMediaOptions(castMediaOptions(builder))
}

/**
 * Set [LaunchOptions] created from the [builder] function.
 */
inline fun CastOptions.Builder.setLaunchOptions(builder: LaunchOptions.Builder.() -> Unit) {
  setLaunchOptions(launchOptions(builder))
}

/**
 * Create an [IntroductoryOverlay] object.
 */
inline fun introductoryOverlay(
  activity: Activity,
  menuItem: MenuItem,
  init: IntroductoryOverlay.Builder.() -> Unit
): IntroductoryOverlay = IntroductoryOverlay.Builder(activity, menuItem).apply(init).build()

/**
 * Create an [IntroductoryOverlay] object.
 */
inline fun introductoryOverlay(
  activity: Activity,
  mediaRouteButton: MediaRouteButton,
  init: IntroductoryOverlay.Builder.() -> Unit
): IntroductoryOverlay = IntroductoryOverlay.Builder(activity, mediaRouteButton).apply(init).build()

/**
 * Create a [CastMediaOptions] object.
 */
inline fun castMediaOptions(init: CastMediaOptions.Builder.() -> Unit): CastMediaOptions =
  CastMediaOptions.Builder().apply(init).build()

/**
 * Set [NotificationOptions] created from the [builder] function.
 */
inline fun CastMediaOptions.Builder.setNotificationOptions(
  builder: NotificationOptions.Builder.() -> Unit
) {
  setNotificationOptions(notificationOptions(builder))
}

/**
 * Create a [NotificationAction] object.
 */
inline fun notificationAction(init: NotificationAction.Builder.() -> Unit): NotificationAction =
  NotificationAction.Builder().apply(init).build()

/**
 * Create a [NotificationOptions] object.
 */
inline fun notificationOptions(init: NotificationOptions.Builder.() -> Unit): NotificationOptions =
  NotificationOptions.Builder().apply(init).build()
