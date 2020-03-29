package org.coronatrace.presentation

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.DrawableRes

fun Context.fetchDrawable(@DrawableRes resId: Int): Drawable {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        getDrawable(resId)!!
    } else {
        resources.getDrawable(resId)
    }
}
