package kr.hs.dgsw.jobdongsani_android.view

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.base.BaseFragment
import kr.hs.dgsw.jobdongsani_android.databinding.FragmentWritePostBinding
import kr.hs.dgsw.jobdongsani_android.viewmodel.WritePostViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class WritePostFragment : BaseFragment<FragmentWritePostBinding, WritePostViewModel>() {
    override val viewModel: WritePostViewModel by viewModels()

    private var onPickImageResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val intent = result.data
            try {
                viewModel.image.value = File(intent?.data?.run(this::getRealPath))
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun observerViewModel() {
        with(mViewModel) {
            onWritePostSuccessEvent.observe(this@WritePostFragment, {
                Toast.makeText(requireContext(), "게시물을 작성하였습니다", Toast.LENGTH_SHORT).show()
                findNavController().navigate(WritePostFragmentDirections.actionWritePostFragmentToPostDetailFragment(it))
            })
            emptyEvent.observe(this@WritePostFragment, {
                Toast.makeText(requireContext(), "빈 칸을 전부 채워주세요.", Toast.LENGTH_SHORT).show()
            })
            mBinding.btnImagePicker.setOnClickListener {
                val intent = Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT)
                onPickImageResult.launch(intent)
            }
            image.observe(this@WritePostFragment, {
                Glide.with(requireContext())
                    .load(it)
                    .into(mBinding.ivThumnail)
                mBinding.ivThumnail.visibility = View.VISIBLE
            })
        }
    }

    private fun getRealPath(uri: Uri): String {
        val contentResolver = requireContext().contentResolver ?: throw NullPointerException()

        val filePath = (requireContext().applicationInfo.dataDir + File.separator
                + System.currentTimeMillis())
        val file = File(filePath)
        try {
            val inputStream = contentResolver.openInputStream(uri) ?: throw NullPointerException()
            val outputStream: OutputStream = FileOutputStream(file)
            val buf = ByteArray(1024)
            var len: Int
            while (inputStream.read(buf).also { len = it } > 0) outputStream.write(buf, 0, len)
            outputStream.close()
            inputStream.close()
            return file.absolutePath
        } catch (e: Exception) {
            throw e
        }
    }

    override fun onErrorEvent(e: Throwable) {
        super.onErrorEvent(e)
        Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT).show()
    }
}