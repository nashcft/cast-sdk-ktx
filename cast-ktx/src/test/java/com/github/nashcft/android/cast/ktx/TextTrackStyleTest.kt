package com.github.nashcft.android.cast.ktx

import com.google.android.gms.cast.TextTrackStyle
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TextTrackStyleTest {

  @Test
  fun `TextTrackStyle builder works`() {
    val scale = 1.5F
    val genericFamily = TextTrackStyle.FONT_FAMILY_SANS_SERIF
    val window = TextTrackStyle.WINDOW_TYPE_ROUNDED
    val style = textTrackStyle {
      fontScale = scale
      fontGenericFamily = genericFamily
      windowType = window
    }

    with(style) {
      assertThat(fontScale).isEqualTo(scale)
      assertThat(fontGenericFamily).isEqualTo(genericFamily)
      assertThat(windowType).isEqualTo(window)
    }
  }
}
