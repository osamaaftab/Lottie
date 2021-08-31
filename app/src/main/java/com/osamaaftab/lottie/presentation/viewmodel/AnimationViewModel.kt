package com.osamaaftab.lottie.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.osamaaftab.lottie.domain.model.ApiResponse
import com.osamaaftab.lottie.domain.model.RequestModel
import com.osamaaftab.lottie.domain.model.ResultModel
import com.osamaaftab.lottie.domain.model.base.ErrorModel
import com.osamaaftab.lottie.domain.usecase.GetAnimatorUsecase
import com.osamaaftab.lottie.domain.usecase.GetFeaturedUsecase
import com.osamaaftab.lottie.domain.usecase.GetPopularUsecase
import com.osamaaftab.lottie.domain.usecase.GetRecentUsecase
import com.osamaaftab.lottie.domain.usecase.base.UseCaseResponse
import com.osamaaftab.lottie.presentation.base.BaseViewModel

class AnimationViewModel(
    private val featuredUsecase: GetFeaturedUsecase,
    private val getRecentUsecase: GetRecentUsecase,
    private val getPopularUsecase: GetPopularUsecase,
    private val getAnimatorUsecase: GetAnimatorUsecase
) : BaseViewModel() {

    private val _onAddResultFeatured = MutableLiveData<List<ResultModel>>()
    private val getResultFeatured: LiveData<List<ResultModel>> = _onAddResultFeatured


    private val _onAddResultRecent = MutableLiveData<List<ResultModel>>()
    private val getResultRecent: LiveData<List<ResultModel>> = _onAddResultRecent


    private val _onAddResultPopular = MutableLiveData<List<ResultModel>>()
    private val getResultPopular: LiveData<List<ResultModel>> = _onAddResultPopular


    private val _onAddResultAnimators = MutableLiveData<List<ResultModel>>()
    private val getResultAnimator: LiveData<List<ResultModel>> = _onAddResultAnimators

    fun getFeaturedUseCaseResponse() = object :
        UseCaseResponse<ApiResponse> {
        override fun onSuccess(response: ApiResponse) {
            _onAddResultFeatured.value = response.data.subData.results
        }


        override fun onError(errorModel: ErrorModel?) {

        }
    }

    fun getResultFeatured(): LiveData<List<ResultModel>> {
        return getResultFeatured
    }

    fun getResultRecent(): LiveData<List<ResultModel>> {
        return getResultRecent
    }

    fun getResultPopular(): LiveData<List<ResultModel>> {
        return getResultPopular
    }

    fun getResultAnimator(): LiveData<List<ResultModel>> {
        return getResultAnimator
    }

    fun getPopularUseCaseResponse() = object :
        UseCaseResponse<ApiResponse> {
        override fun onSuccess(response: ApiResponse) {
            Log.d("popular", response.data.subData.results.size.toString())
            _onAddResultPopular.value = response.data.subData.results

        }


        override fun onError(errorModel: ErrorModel?) {
            Log.d("OnError", errorModel?.message.toString())
        }
    }

    fun getRecentUseCaseResponse() = object :
        UseCaseResponse<ApiResponse> {
        override fun onSuccess(response: ApiResponse) {
            Log.d("recent", response.data.subData.results.size.toString())
            _onAddResultRecent.value = response.data.subData.results

        }


        override fun onError(errorModel: ErrorModel?) {
            Log.d("OnError", errorModel?.message.toString())
        }
    }

    fun getAnimatorUseCaseResponse() = object :
        UseCaseResponse<ApiResponse> {
        override fun onSuccess(response: ApiResponse) {
            _onAddResultAnimators.value = response.data.subData.results
        }


        override fun onError(errorModel: ErrorModel?) {
            Log.d("OnError", errorModel?.message.toString())
        }
    }

    fun getFeaturedAnimation() {
        featuredUsecase.invoke(
            scope, RequestModel(featuredUsecaseToken, "media"), getFeaturedUseCaseResponse()
        )
    }

    fun getRecentAnimation() {
        getRecentUsecase.invoke(
            scope, RequestModel(recentUsecaseToken, "media"), getRecentUseCaseResponse()
        )
    }

    fun getAnimatorsProfiles() {
        getAnimatorUsecase.invoke(
            scope, RequestModel(animatorsUsecaseToken, "media"), getAnimatorUseCaseResponse()
        )
    }

    fun getPopularAnimation() {
        getPopularUsecase.invoke(
            scope, RequestModel(popularUsecaseToken, "media"), getPopularUseCaseResponse()
        )
    }
}