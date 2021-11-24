package kr.hs.dgsw.jobdongsani_android.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.adapter.SearchPostAdapter
import kr.hs.dgsw.jobdongsani_android.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = DataBindingUtil.inflate<FragmentSearchBinding>(inflater,
            R.layout.fragment_search,
            container,
            false)
        binding.lifecycleOwner = this

        val searchPostAdapter = SearchPostAdapter().apply {
            submitList(listOf(Any(), Any(), Any(), Any(), Any(), Any(), Any()))
        }

        binding.rvSearchPost.adapter = searchPostAdapter


        return binding.root
    }
}