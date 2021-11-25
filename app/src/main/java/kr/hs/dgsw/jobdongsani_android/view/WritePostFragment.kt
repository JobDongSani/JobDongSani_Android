package kr.hs.dgsw.jobdongsani_android.view

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.base.BaseFragment
import kr.hs.dgsw.jobdongsani_android.databinding.FragmentWritePostBinding
import kr.hs.dgsw.jobdongsani_android.viewmodel.WritePostViewModel

class WritePostFragment : BaseFragment<FragmentWritePostBinding, WritePostViewModel>() {
    override val viewModel: WritePostViewModel by viewModels()

    override fun observerViewModel() {
        with(mViewModel) {
            onWritePostSuccessEvent.observe(this@WritePostFragment, {
                Toast.makeText(requireContext(), "게시물 작성 성공", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_writePostFragment_to_homeFragment)
            })
            emptyEvent.observe(this@WritePostFragment, {
                Toast.makeText(requireContext(), "빈 칸을 전부 채워주세요.", Toast.LENGTH_SHORT).show()
            })
            onImagePickEvent.observe(this@WritePostFragment, {

            })
        }
    }
}