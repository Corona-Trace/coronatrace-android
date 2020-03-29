package org.coronatrace.presentation.intro

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.size
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import org.coronatrace.presentation.R
import org.coronatrace.presentation.base.BaseFragment
import org.coronatrace.presentation.databinding.FragmentIntroBinding
import org.coronatrace.presentation.onPageChanged

class IntroFragment : BaseFragment<IntroViewModel, FragmentIntroBinding>(R.layout.fragment_intro) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            vpIntro.adapter =
                IntroStateAdapter(requireActivity().supportFragmentManager, lifecycle)
            vpIntro.onPageChanged {
                btnNext.text = when(it) {
                    0 -> getString(R.string.button_see_how_it_works_default)
                    INTRO_PAGES - 1 -> getString(R.string.button_get_started)
                    else -> getString(R.string.button_continue)
                }
            }
            TabLayoutMediator(tabs, vpIntro) { _, _ -> }.attach()
            btnNext.setOnClickListener { vpIntro.currentItem++ }
        }
    }

    companion object {
        const val INTRO_PAGES = 4
    }
}