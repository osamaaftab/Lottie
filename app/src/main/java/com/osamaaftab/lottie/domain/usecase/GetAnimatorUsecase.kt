package com.osamaaftab.lottie.domain.usecase

import com.osamaaftab.lottie.domain.model.ApiResponse
import com.osamaaftab.lottie.domain.model.RequestModel
import com.osamaaftab.lottie.domain.repository.ProfileRepository
import com.osamaaftab.lottie.domain.usecase.base.UseCase
import com.osamaaftab.lottie.util.handler.ApiErrorHandle

class GetAnimatorUsecase constructor(
    private val profileRepository: ProfileRepository,
    apiErrorHandle: ApiErrorHandle?
) :
    UseCase<ApiResponse, Any?>(apiErrorHandle) {
    override suspend fun run(requestModel: RequestModel): ApiResponse {
        return profileRepository.getAnimatorProfiles(requestModel)
    }
}