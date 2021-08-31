package com.osamaaftab.lottie.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(
        @SerializedName(
                "popular",
                alternate = ["featured", "recent", "featuredAnimators"]
        ) var subData: SubDataModel
) :
        Parcelable