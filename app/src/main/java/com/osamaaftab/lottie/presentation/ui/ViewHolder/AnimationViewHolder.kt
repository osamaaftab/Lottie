package com.osamaaftab.lottie.presentation.ui.ViewHolder

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.osamaaftab.lottie.presentation.ui.GenericAdapter

class AnimationViewHolder<T>(
    private val viewDataBinding: ViewDataBinding,
) : RecyclerView.ViewHolder(viewDataBinding.root),
    GenericAdapter.Binder<T> {


    override fun bind(data: T, position: Int) {
        viewDataBinding.setVariable(BR.data,data)
        viewDataBinding.executePendingBindings()
    }

    override fun bindList(data: List<T>) {
    }
}