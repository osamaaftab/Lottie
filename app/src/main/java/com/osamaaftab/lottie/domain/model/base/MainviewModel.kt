package com.osamaaftab.lottie.domain.model.base

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainviewModel(
    val title:String
) :
    Parcelable