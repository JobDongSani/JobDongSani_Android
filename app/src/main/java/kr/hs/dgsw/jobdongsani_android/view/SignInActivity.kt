package kr.hs.dgsw.jobdongsani_android.view

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import androidx.activity.viewModels
import androidx.annotation.ColorRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.hs.dgsw.jobdongsani_android.MainActivity
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.databinding.ActivityMainBinding
import kr.hs.dgsw.jobdongsani_android.databinding.ActivitySignInBinding
import kr.hs.dgsw.jobdongsani_android.viewmodel.SignInViewModel

class SignInActivity : AppCompatActivity() {

    private lateinit var mPreferences: SharedPreferences
    private val mViewModel : SignInViewModel by viewModels()
    private lateinit var mBinding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivitySignInBinding>(this, R.layout.activity_sign_in)
        binding.lifecycleOwner = this

        (binding.tvAppTitle.text as Spannable).setSpan(RelativeSizeSpan(2f), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        (binding.tvAppTitle.text as Spannable).setSpan(ForegroundColorSpan(resources.getColor(R.color.main)), 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        (binding.tvRegisterTitle.text as Spannable).setSpan(ForegroundColorSpan(resources.getColor(R.color.main)), 15, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        mPreferences = getSharedPreferences("SignInActivity", MODE_PRIVATE)
        mBinding = binding

    }

    fun observerViewModel() {
        with(mViewModel) {
            loginEvent.observe(this@SignInActivity, {

                val preferencesEditor: SharedPreferences.Editor = mPreferences.edit()
                preferencesEditor.putString("token", loginEvent.value)
                preferencesEditor.apply()

                val intent = Intent(this@SignInActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            })
            onSignUpEvent.observe(this@SignInActivity, {
                val intent = Intent()
                startActivity(intent)
            })
        }
    }
}