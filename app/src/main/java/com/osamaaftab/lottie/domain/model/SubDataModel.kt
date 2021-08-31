package com.osamaaftab.lottie.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SubDataModel(
    val currentPage: Int,
    val perPage: Int,
    val totalPages: Int,
    val from: Int,
    val to: Int,
    val total: Int,
    val results: List<ResultModel>
) :
    Parcelable