package com.alrayes.domain.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


abstract class UseCase<INPUT, OUTPUT>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(input: INPUT) = withContext(coroutineDispatcher) {
        execute(input)
    }

    protected abstract suspend fun execute(input: INPUT): OUTPUT

}