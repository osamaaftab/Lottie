package com.osamaaftab.lottie.presentation.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

abstract class GenericAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemList: List<T> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderDataBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), getLayoutId(), parent, false
        )
        return getViewHolder(holderDataBinding)
    }

    protected abstract fun getLayoutId(): Int

    abstract fun getViewHolder(viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder

    internal interface Binder<in U> {
        fun bind(data: U, position: Int)
        fun bindList(data: List<U>)
    }

    override fun getItemCount(): Int {
        return if (itemList.isNullOrEmpty()) 0 else itemList.size
    }

    private fun getItem(position: Int): T {
        return itemList[position]
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).bind(getItem(position), position)
        (holder as Binder<T>).bindList(itemList)
    }
}