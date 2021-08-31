package com.osamaaftab.lottie.domain.repository

import com.osamaaftab.lottie.domain.model.ApiResponse
import com.osamaaftab.lottie.domain.model.RequestModel

interface AnimationRepository {
    suspend fun getRecentAnimation(requestModel: RequestModel): ApiResponse
    suspend fun getPopularAnimation(requestModel: RequestModel): ApiResponse
    suspend fun getFeaturedAnimation(requestModel: RequestModel): ApiResponse
}