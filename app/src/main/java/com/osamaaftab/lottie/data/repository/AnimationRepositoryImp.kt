package com.osamaaftab.lottie.data.repository

import com.osamaaftab.lottie.data.services.AnimationServices
import com.osamaaftab.lottie.domain.model.ApiResponse
import com.osamaaftab.lottie.domain.model.RequestModel
import com.osamaaftab.lottie.domain.repository.AnimationRepository

class AnimationRepositoryImp(private val animationServices: AnimationServices) : AnimationRepository {
    override suspend fun getRecentAnimation(requestModel: RequestModel): ApiResponse {
       return animationServices.getRecentAnimationAsync(requestModel.alt,requestModel.token).await()
    }

    override suspend fun getPopularAnimation(requestModel: RequestModel): ApiResponse {
       return animationServices.getPopularAnimationAsync(requestModel.alt,requestModel.token).await()
    }

    override suspend fun getFeaturedAnimation(requestModel: RequestModel): ApiResponse {
      return  animationServices.getFeaturedAnimationAsync(requestModel.alt,requestModel.token).await()
    }
}