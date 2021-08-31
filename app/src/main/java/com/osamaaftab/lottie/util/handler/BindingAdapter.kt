package com.osamaaftab.lottie.util.handler


import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.osamaaftab.flow.CircularImageView
import com.osamaaftab.flow.Flow
import com.osamaaftab.lottie.R
import com.osamaaftab.lottie.domain.model.ResultModel
import com.osamaaftab.lottie.presentation.ui.GenericAdapter
import com.osamaaftab.lottie.presentation.ui.ViewHolder.AnimationViewHolder
import com.osamaaftab.lottie.presentation.ui.ViewHolder.AnimatorViewHolder
import com.osamaaftab.lottie.presentation.viewmodel.AnimationViewModel

private var featuredAdapter: GenericAdapter<ResultModel>? = null
private var recentAdapter: GenericAdapter<ResultModel>? = null
private var popularAdapter: GenericAdapter<ResultModel>? = null
private var animatorsAdapter: GenericAdapter<ResultModel>? = null


@BindingAdapter("position", "viewmodel", "lifecycle")
fun RecyclerView.load(
    position: Int,
    animationViewModel: AnimationViewModel,
    lifecycleOwner: LifecycleOwner
) {
    when (position) {
        0 -> {
            initFeaturedAdapter(this)
            initObserver(animationViewModel.getResultFeatured(), lifecycleOwner, featuredAdapter)
            animationViewModel.getFeaturedAnimation()
        }
        1 -> {
            initRecentAdapter(this)
            initObserver(animationViewModel.getResultRecent(), lifecycleOwner, recentAdapter)
            animationViewModel.getRecentAnimation()
        }
        2 -> {
            initPopularAdapter(this)
            initObserver(animationViewModel.getResultPopular(), lifecycleOwner, popularAdapter)
            animationViewModel.getPopularAnimation()
        }
        3 -> {
            initAnimatorAdapter(this)
            initObserver(animationViewModel.getResultAnimator(), lifecycleOwner, animatorsAdapter)
            animationViewModel.getAnimatorsProfiles()
        }
    }
}

private fun initFeaturedAdapter(recyclerView: RecyclerView) {
    featuredAdapter = object : GenericAdapter<ResultModel>() {

        override fun getViewHolder(viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder {
            return AnimationViewHolder<ResultModel>(viewDataBinding)
        }

        override fun getLayoutId(): Int {
            return R.layout.animation_item
        }
    }
    recyclerView.adapter = featuredAdapter
}

private fun initRecentAdapter(recyclerView: RecyclerView) {
    recentAdapter = object : GenericAdapter<ResultModel>() {

        override fun getViewHolder(viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder {
            return AnimationViewHolder<ResultModel>(viewDataBinding)
        }

        override fun getLayoutId(): Int {
            return R.layout.animation_item
        }
    }
    recyclerView.adapter = recentAdapter
}

private fun initPopularAdapter(recyclerView: RecyclerView) {
    popularAdapter = object : GenericAdapter<ResultModel>() {

        override fun getViewHolder(viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder {
            return AnimationViewHolder<ResultModel>(viewDataBinding)
        }

        override fun getLayoutId(): Int {
            return R.layout.animation_item
        }
    }
    recyclerView.adapter = popularAdapter
}

private fun initAnimatorAdapter(recyclerView: RecyclerView) {
    animatorsAdapter = object : GenericAdapter<ResultModel>() {

        override fun getViewHolder(viewDataBinding: ViewDataBinding): RecyclerView.ViewHolder {
            return AnimatorViewHolder<ResultModel>(viewDataBinding)
        }

        override fun getLayoutId(): Int {
            return R.layout.animator_item
        }
    }
    recyclerView.adapter = animatorsAdapter
}


@BindingAdapter("lottie_url")
fun LottieAnimationView.play(url: String) {
    this.setAnimationFromUrl(url)
}

@BindingAdapter("img_url")
fun CircularImageView.load(url:String){
    Flow.getInstance(this.context, 4).displayImage(url,this, R.drawable.ic_user)
}

private fun initObserver(
    observer: LiveData<List<ResultModel>>,
    lifecycleOwner: LifecycleOwner, adapter: GenericAdapter<ResultModel>?
) {
    observer.observe(
        lifecycleOwner,
        Observer {
            adapter?.itemList = it
        })
}


