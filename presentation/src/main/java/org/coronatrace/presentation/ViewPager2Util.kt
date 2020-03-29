package org.coronatrace.presentation

import androidx.viewpager2.widget.ViewPager2

inline fun ViewPager2.onPageChanged(crossinline lambda: (Int) -> Unit) {
    this.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            lambda(position)
        }
    })
}