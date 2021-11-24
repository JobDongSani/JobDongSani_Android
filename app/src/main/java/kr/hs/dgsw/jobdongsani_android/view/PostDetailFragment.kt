package kr.hs.dgsw.jobdongsani_android.view

import androidx.fragment.app.viewModels
import kr.hs.dgsw.jobdongsani_android.base.BaseFragment
import kr.hs.dgsw.jobdongsani_android.databinding.FragmentPostDetailBinding
import kr.hs.dgsw.jobdongsani_android.viewmodel.PostDetailViewModel

class PostDetailFragment : BaseFragment<FragmentPostDetailBinding, PostDetailViewModel>() {

    override val viewModel: PostDetailViewModel by viewModels()

    override fun observerViewModel() {
        with(viewModel) {

        }
    }

}