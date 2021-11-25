package kr.hs.dgsw.jobdongsani_android.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import kr.hs.dgsw.jobdongsani_android.R
import kr.hs.dgsw.jobdongsani_android.adapter.PickWasteTypeAdapter
import kr.hs.dgsw.jobdongsani_android.databinding.DialogPickWasteTypeBinding
import kr.hs.dgsw.jobdongsani_android.util.WasteType.wasteType
import kr.hs.dgsw.jobdongsani_android.viewmodel.PickWasteTypeViewModel

class PickWasteTypeDialog(val barcode: String) : DialogFragment() {

    val viewModel: PickWasteTypeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = DataBindingUtil.inflate<DialogPickWasteTypeBinding>(inflater,
            R.layout.dialog_pick_waste_type,
            container,
            false)
        binding.lifecycleOwner = viewLifecycleOwner

        val pickWasteTypeAdapter = PickWasteTypeAdapter().apply {
            submitList(wasteType.keys.toList())
        }

        PickWasteTypeAdapter.onClick.observe(this, {
            viewModel.postProduct(barcode, it)
        })

        viewModel.getIsLoading().observe(this, {
            dismiss()
        })
        viewModel.onErrorEvent.observe(this, {
            Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
        })

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        binding.rvWasteType.adapter = pickWasteTypeAdapter

        isCancelable = false

        return binding.root
    }
}