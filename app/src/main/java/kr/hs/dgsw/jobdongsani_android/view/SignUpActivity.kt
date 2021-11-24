package kr.hs.dgsw.jobdongsani_android.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.databinding.ActivitySignUpBinding
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import android.content.Intent
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import kr.hs.dgsw.jobdongsani_android.viewmodel.SignUpViewModel

class SignUpActivity : AppCompatActivity() {

    val viewModel: SignUpViewModel by viewModels()

    var onPickImageResult = registerForActivityResult(
        StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val intent = result.data
            try {
                 viewModel.image.value = File(intent?.data?.run(this::getRealPath))
            } catch (e: Exception) {
                Toast.makeText(this, "${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivitySignUpBinding>(this, R.layout.activity_sign_up)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        binding.btnImage.setOnClickListener {
            val intent = Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT)
            onPickImageResult.launch(intent)
        }

        viewModel.image.observe(this, {
            Glide.with(this)
                .load(viewModel.image.value)
                .into(binding.btnImage)
            binding.btnImage.setBorderWidth(0F)
        })
        viewModel.onErrorEvent.observe(this, {
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        })
        viewModel.isSuccess.observe(this, {
            if(it) {
                Toast.makeText(this, "회원가입 하였습니다", Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }

    fun getRealPath(uri: Uri): String {
        val contentResolver = this.contentResolver ?: throw NullPointerException()

        val filePath = (this.applicationInfo.dataDir + File.separator
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
}