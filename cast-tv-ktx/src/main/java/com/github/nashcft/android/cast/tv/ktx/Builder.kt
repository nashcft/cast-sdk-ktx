package com.github.nashcft.android.cast.tv.ktx

import android.content.Context
import com.google.android.gms.cast.tv.CastReceiverOptions

/**
 * Create a [CastReceiverOptions] object.
 */
inline fun castReceiverOptions(
  context: Context,
  init: CastReceiverOptions.Builder.() -> Unit
): CastReceiverOptions = CastReceiverOptions.Builder(context).apply(init).build()
