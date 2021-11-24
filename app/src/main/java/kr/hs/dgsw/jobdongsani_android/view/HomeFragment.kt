package kr.hs.dgsw.jobdongsani_android.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.adapter.SharePostAdapter
import kr.hs.dgsw.jobdongsani_android.base.BaseFragment
import kr.hs.dgsw.jobdongsani_android.databinding.FragmentHomeBinding
import kr.hs.dgsw.jobdongsani_android.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override val isBottomNavFragment = true

    override fun observerViewModel() {

        val sharePostAdapter = SharePostAdapter().apply {
            submitList(listOf(Any(), Any(), Any()))
        }

        mBinding.btnBarcode.setOnClickListener {
            val intent= Intent(requireContext(), BarcodeActivity::class.java)
            startActivity(intent)
        }

        mBinding.rvSharePost.adapter = sharePostAdapter
    }

}