package kr.hs.dgsw.jobdongsani_android.view

import androidx.fragment.app.viewModels
import kr.hs.dgsw.jobdongsani_android.adapter.SearchPostAdapter
import kr.hs.dgsw.jobdongsani_android.base.BaseFragment
import kr.hs.dgsw.jobdongsani_android.databinding.FragmentSearchBinding
import kr.hs.dgsw.jobdongsani_android.viewmodel.SearchViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()

    override val isBottomNavFragment = true

    override fun observerViewModel() {
        val searchPostAdapter = SearchPostAdapter().apply {
            submitList(listOf(Any(), Any(), Any(), Any(), Any(), Any(), Any()))
        }

        mBinding.rvSearchPost.adapter = searchPostAdapter
    }
}