package com.osamaaftab.lottie.presentation.ui.ViewHolder

import androidx.databinding.library.baseAdapters.BR
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.osamaaftab.lottie.presentation.ui.GenericAdapter
import com.osamaaftab.lottie.presentation.viewmodel.AnimationViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainViewHolder<T>(
    private val viewDataBinding: ViewDataBinding,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(viewDataBinding.root),
    GenericAdapter.Binder<T>, KoinComponent {
    private val animationViewModel: AnimationViewModel by inject()


    override fun bind(data: T, position: Int) {
        viewDataBinding.setVariable(BR.data, data)
        viewDataBinding.setVariable(BR.position,position)
        viewDataBinding.setVariable(BR.lifecylce,lifecycleOwner)
        viewDataBinding.setVariable(BR.viewModel, animationViewModel)
        animationViewModel.getFeaturedAnimation()
        viewDataBinding.executePendingBindings()
    }

    override fun bindList(data: List<T>) {
    }
}