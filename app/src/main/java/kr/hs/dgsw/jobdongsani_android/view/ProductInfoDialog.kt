package kr.hs.dgsw.jobdongsani_android.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.databinding.DialogProductInfoBinding
import kr.hs.dgsw.jobdongsani_android.model.local.entity.ProductEntity

class ProductInfoDialog(val productEntity: ProductEntity) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = DataBindingUtil.inflate<DialogProductInfoBinding>(
            layoutInflater, R.layout.dialog_product_info, container, false
        )

        binding.tvProductName.text = productEntity.title
        binding.tvRecycleWay.text = productEntity.way
        binding.tvType.text = productEntity.wasteType

        return binding.root
    }
}