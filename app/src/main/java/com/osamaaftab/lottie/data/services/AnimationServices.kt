package com.osamaaftab.lottie.data.services

import com.osamaaftab.lottie.domain.model.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


interface AnimationServices {
    @GET("featuredAnimations.json")
    fun getFeaturedAnimationAsync(
        @Query("alt") alt: String,
        @Query("token") token: String
    ): Deferred<ApiResponse>
    
    @GET("popularAnimations.json")
    fun getPopularAnimationAsync(
        @Query("alt") alt: String,
        @Query("token") token: String
    ): Deferred<ApiResponse>


    @GET("recentAnimations.json")
    fun getRecentAnimationAsync(
        @Query("alt") alt: String,
        @Query("token") token: String
    ): Deferred<ApiResponse>
}