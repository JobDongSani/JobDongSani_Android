package kr.hs.dgsw.jobdongsani_android.base

import kr.hs.dgsw.jobdongsani_android.MainActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import kr.hs.dgsw.jobdongsani_android.R
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    protected open val isBottomNavFragment : Boolean = false

    protected lateinit var mBinding: VB
    protected lateinit var mViewModel: VM

    protected abstract val viewModel: VM

    protected abstract fun observerViewModel()

    protected open fun onErrorEvent(e: Throwable) {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater, layoutRes(), container, false
        )!!
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? MainActivity)?.setBottomNavVisibility(isBottomNavFragment)
        setUp()

        mViewModel.onErrorEvent.observe(viewLifecycleOwner, { onErrorEvent(it) })

        observerViewModel()
    }

    private fun setUp() {
        mViewModel = if (::mViewModel.isInitialized) mViewModel else viewModel
        mBinding.setVariable(BR.vm, mViewModel)
        mBinding.lifecycleOwner = this
        mBinding.executePendingBindings()
    }

    /**
     * Generic Type (Binding) class 를 가져와서 layout 파일명으로 변환 후 자동으로 Layout Resource 를 가져옴
     *
     * @return layout resource
     */
    @LayoutRes
    private fun layoutRes(): Int {
        val split =
            ((Objects.requireNonNull<Type>(javaClass.genericSuperclass) as ParameterizedType).actualTypeArguments[0] as Class<*>)
                .simpleName.replace("Binding$".toRegex(), "")
                .split("(?<=.)(?=\\p{Upper})".toRegex())
                .dropLastWhile { it.isEmpty() }.toTypedArray()

        val name = StringBuilder()

        for (i in split.indices) {
            name.append(split[i].toLowerCase(Locale.ROOT))
            if (i != split.size - 1)
                name.append("_")
        }

        try {
            return R.layout::class.java.getField(name.toString()).getInt(R.layout::class.java)
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        }

        return 0
    }
}