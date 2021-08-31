package com.osamaaftab.lottie.domain.repository

import com.osamaaftab.lottie.domain.model.ApiResponse
import com.osamaaftab.lottie.domain.model.RequestModel

interface ProfileRepository {
    suspend fun getAnimatorProfiles(requestModel: RequestModel): ApiResponse
}