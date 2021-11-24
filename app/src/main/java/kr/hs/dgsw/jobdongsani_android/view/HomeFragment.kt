package kr.hs.dgsw.jobdongsani_android.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.adapter.SharePostAdapter
import kr.hs.dgsw.jobdongsani_android.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home, container, false)
        binding.lifecycleOwner = this

        val sharePostAdapter = SharePostAdapter().apply {
            submitList(listOf(Any(), Any(), Any()))
        }

        binding.btnBarcode.setOnClickListener {

        }

        binding.rvSharePost.adapter = sharePostAdapter

        return binding.root
    }
}