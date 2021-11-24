package kr.hs.dgsw.jobdongsani_android.view

import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import androidx.annotation.ColorRes
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.databinding.ActivityMainBinding
import kr.hs.dgsw.jobdongsani_android.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySignInBinding>(this, R.layout.activity_sign_in)
        binding.lifecycleOwner = this

        (binding.tvAppTitle.text as Spannable).setSpan(RelativeSizeSpan(2f), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        (binding.tvAppTitle.text as Spannable).setSpan(ForegroundColorSpan(resources.getColor(R.color.main)), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    }
}