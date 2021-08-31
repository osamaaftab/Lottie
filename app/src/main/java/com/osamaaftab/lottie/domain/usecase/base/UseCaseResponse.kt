package com.osamaaftab.lottie.domain.usecase.base

import com.osamaaftab.lottie.domain.model.base.ErrorModel

interface UseCaseResponse<in Type> {

    fun onSuccess(result: Type)

    fun onError(errorModel: ErrorModel?)
}