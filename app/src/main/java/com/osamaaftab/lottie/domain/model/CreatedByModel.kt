package com.osamaaftab.lottie.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CreatedByModel(
    val avatarUrl: String,
    val name: String
) :
    Parcelable