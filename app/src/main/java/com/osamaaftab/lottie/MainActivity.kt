package com.osamaaftab.lottie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.osamaaftab.lottie.databinding.ActivityMainBinding
import com.osamaaftab.lottie.domain.model.base.MainviewModel
import com.osamaaftab.lottie.presentation.ui.GenericAdapter
import com.osamaaftab.lottie.presentation.ui.ViewHolder.MainViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var animationAdapter: GenericAdapter<MainviewModel>? = null
    val mainViewList: List<MainviewModel> =
        listOf(
            MainviewModel("Featured Animation"),
            MainviewModel("Recent Animation"),
            MainviewModel("Popular Animation"),
            MainviewModel("Animators")
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.lifecycleOwner = this
        initAdapter()
    }


    private fun initAdapter() {
        animationAdapter = object : GenericAdapter<MainviewModel>() {

            override fun getViewHolder(viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder {
                return MainViewHolder<MainviewModel>(viewDataBinding, this@MainActivity)
            }

            override fun getLayoutId(): Int {
                return R.layout.main_view_item
            }
        }
        activityMainBinding.animationRecyclerView.adapter = animationAdapter
        animationAdapter?.itemList = mainViewList
        activityMainBinding.animationRecyclerView.visibility = View.VISIBLE
    }
}