package com.osamaaftab.lottie.data.repository

import com.osamaaftab.lottie.data.services.ProfileServices
import com.osamaaftab.lottie.domain.model.ApiResponse
import com.osamaaftab.lottie.domain.model.RequestModel
import com.osamaaftab.lottie.domain.repository.ProfileRepository


class ProfileRepositoryImp(private val profileServices: ProfileServices) :
    ProfileRepository {
    override suspend fun getAnimatorProfiles(requestModel: RequestModel): ApiResponse {
        return profileServices.getAnimatorProfilesAsync(requestModel.alt,requestModel.token).await()
    }
}