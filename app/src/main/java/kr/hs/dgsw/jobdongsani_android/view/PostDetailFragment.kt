package kr.hs.dgsw.jobdongsani_android.view

import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import kr.hs.dgsw.jobdongsani_android.base.BaseFragment
import kr.hs.dgsw.jobdongsani_android.databinding.FragmentPostDetailBinding
import kr.hs.dgsw.jobdongsani_android.viewmodel.PostDetailViewModel

class PostDetailFragment : BaseFragment<FragmentPostDetailBinding, PostDetailViewModel>() {

    override val viewModel: PostDetailViewModel by viewModels()

    override fun observerViewModel() {
        with(viewModel) {
            val id = arguments?.getInt("id") ?: 0
            getTrashShareBoard(id)
            board.observe(this@PostDetailFragment, {
                mBinding.tvTitle.text = it.title
                mBinding.tvWriter.text = it.writer
                mBinding.tvContent.text = it.contents
                mBinding.tvContact.text = "연락처: ${it.contact}"

                Glide.with(requireContext())
                    .load(it.imagePath)
                    .into(mBinding.tvThumbnail)

            })
        }
    }

}