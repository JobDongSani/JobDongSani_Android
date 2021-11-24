package kr.hs.dgsw.jobdongsani_android.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.zxing.integration.android.IntentIntegrator
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.databinding.ActivityBarcodeBinding
import kr.hs.dgsw.jobdongsani_android.viewmodel.BarcodeViewModel

class BarcodeActivity : AppCompatActivity() {

    val viewModel: BarcodeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityBarcodeBinding>(this, R.layout.activity_barcode)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        initBarcodeScanner()

        viewModel.result.observe(this, {
            binding.tvProductName.text = it.title
            toggleTextView(binding, true)
        })
        viewModel.onErrorEvent.observe(this, {
            toggleTextView(binding, false)
        })
    }

    private fun initBarcodeScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setBeepEnabled(false)
        integrator.setOrientationLocked(false)
        integrator.setPrompt("QR 코드를 입력해주세요.")
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        val barcode = result.contents
        viewModel.getResult("8801062221974")
    }

    fun toggleTextView(binding: ActivityBarcodeBinding, isExist: Boolean) {
        if (isExist) {
            binding.tvProductName.visibility = View.VISIBLE
            binding.tvSeparateCollection.visibility = View.VISIBLE
            binding.tvType.visibility = View.VISIBLE
            binding.tvNoneInfo.visibility = View.GONE
            binding.tvBarcode.text = "검색 완료"
            binding.tvBarcode.setTextColor(Color.parseColor("#9FE29D"))
        } else {
            binding.tvProductName.visibility = View.GONE
            binding.tvSeparateCollection.visibility = View.GONE
            binding.tvType.visibility = View.GONE
            binding.tvNoneInfo.visibility = View.VISIBLE
            binding.tvBarcode.text = "바코드를 인식시켜주세요"
            binding.tvBarcode.setTextColor(Color.parseColor("#FFFFFF"))
        }
    }
}