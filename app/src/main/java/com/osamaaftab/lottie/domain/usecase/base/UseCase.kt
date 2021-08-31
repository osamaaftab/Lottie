package com.osamaaftab.lottie.domain.usecase.base

import com.osamaaftab.lottie.domain.model.RequestModel
import com.osamaaftab.lottie.util.handler.ApiErrorHandle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
abstract class UseCase<ReturnType, in Params>(private val apiErrorHandle: ApiErrorHandle?) where ReturnType : Any {

    abstract suspend fun run(requestModel: RequestModel): ReturnType

    fun invoke(scope: CoroutineScope, requestModel: RequestModel, onResult: UseCaseResponse<ReturnType>) {
        scope.launch {
            try {
                withContext(Dispatchers.IO) {
                    run(requestModel)
                }.let {
                    onResult.onSuccess(it)
                }
            } catch (e: Throwable) {
                onResult.onError(apiErrorHandle?.traceErrorException(e))
            }
        }
    }
}