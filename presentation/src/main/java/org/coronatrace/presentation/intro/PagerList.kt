package org.coronatrace.presentation.intro

import android.content.Context
import android.graphics.drawable.Drawable
import org.coronatrace.presentation.R
import org.coronatrace.presentation.fetchDrawable

object PagerList {
    fun get(context: Context): List<IntroPage> = context.run {
        listOf(
            IntroPage(
                getString(R.string.intro_page2_subtitle),
                getString(R.string.intro_page2_description),
                fetchDrawable(R.drawable.location_circles)),
            IntroPage(
                getString(R.string.intro_page3_subtitle),
                getString(R.string.intro_page3_description),
                fetchDrawable(R.drawable.map_graphic)),
            IntroPage(
                getString(R.string.intro_page4_subtitle),
                getString(R.string.intro_page4_description),
                fetchDrawable(R.drawable.ic_status))
        )
    }
}

data class IntroPage(
    val title: String,
    val subtitle: String,
    val drawable: Drawable
)