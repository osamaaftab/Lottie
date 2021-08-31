package com.osamaaftab.lottie.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ApiResponse(val data: DataModel) : Parcelable