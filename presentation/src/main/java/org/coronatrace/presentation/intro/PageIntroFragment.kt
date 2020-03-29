package org.coronatrace.presentation.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import org.coronatrace.presentation.R
import org.coronatrace.presentation.databinding.FragmentPageIntroDynamicBinding

class PageIntroFragment : Fragment() {
    lateinit var binding: ViewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pos = requireArguments()[POSITION] as Int
        val layoutId = if (pos == 0) R.layout.fragment_page_intro else R.layout.fragment_page_intro_dynamic
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = PagerList.get(requireContext())
        val pos = requireArguments()[POSITION] as Int - 1
        (binding as? FragmentPageIntroDynamicBinding)?.apply {
            tvSubtitle.text = items[pos].title
            tvDescription.text = items[pos].subtitle
            ivMain.setImageDrawable(items[pos].drawable)
        }
    }

    companion object {
        const val POSITION = "POSITION"
        fun create(position: Int): PageIntroFragment {
            return PageIntroFragment().apply {
                arguments = bundleOf(POSITION to position)
            }
        }
    }
}