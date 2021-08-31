package com.osamaaftab.lottie.data.services

import com.osamaaftab.lottie.domain.model.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileServices {

    @GET("featuredAnimators.json")
    fun getAnimatorProfilesAsync(
        @Query("alt") alt: String,
        @Query("token") token: String
    ): Deferred<ApiResponse>
}