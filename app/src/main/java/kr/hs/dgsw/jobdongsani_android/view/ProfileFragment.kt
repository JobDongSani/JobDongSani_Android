package kr.hs.dgsw.jobdongsani_android.view

import androidx.fragment.app.viewModels
import kr.hs.dgsw.jobdongsani_android.adapter.RecyclePostAdapter
import kr.hs.dgsw.jobdongsani_android.base.BaseFragment
import kr.hs.dgsw.jobdongsani_android.databinding.FragmentProfileBinding
import kr.hs.dgsw.jobdongsani_android.viewmodel.ProfileViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override val viewModel: ProfileViewModel by viewModels()

    override val isBottomNavFragment = true

    override fun observerViewModel() {
        with(mViewModel) {
            val recyclePostAdapter = RecyclePostAdapter()
            mBinding.rvRecyclePost.adapter = recyclePostAdapter
            getSavedProduct()
            onProductListResult.observe(this@ProfileFragment, {
                recyclePostAdapter.submitList(it)
            })
        }
    }

}