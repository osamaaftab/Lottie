package com.osamaaftab.lottie.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultModel(
    val id: Int,
    val bgColor: String,
    val lottieUrl: String,
    val gifUrl: String,
    val videoUrl: String,
    val imageUrl: String,
    val name: String,
    val avatarUrl: String,
    val createdBy: CreatedByModel
) :
    Parcelable