package com.tkisor.utiljs.kubejs

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeoutException

object AsyncJS {
    @JvmStatic
    fun parallel(tasks: Array<Runnable>): CompletableFuture<Void> {
        val future = CompletableFuture<Void>()

        CoroutineScope(Dispatchers.Default).launch {
            tasks.map { task ->
                async { task.run() }
            }.awaitAll()
            future.complete(null)
        }

        return future
    }

    private fun parallel(scope: CoroutineScope, tasks: Array<Runnable>): Deferred<List<Unit>> {
        return scope.async {
            tasks.map { task ->
                scope.async { task.run() }
            }.awaitAll()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @JvmStatic
    fun timeout(ms: Long, task: Runnable): CompletableFuture<Void> {
        val future = CompletableFuture<Void>()

        GlobalScope.launch {
            try {
                withTimeout(ms) {
                    task.run()
                }
                future.complete(null)
            } catch (e: TimeoutCancellationException) {
                future.completeExceptionally(TimeoutException("Task timed out after $ms ms")) // 超时异常
            } catch (e: Exception) {
                future.completeExceptionally(e)
            }
        }

        return future
    }

    @OptIn(DelicateCoroutinesApi::class)
    @JvmStatic
    fun retry(max: Int, task: Runnable): CompletableFuture<Void> {
        val future = CompletableFuture<Void>()

        GlobalScope.launch {
            var lastError: Throwable? = null
            repeat(max) {
                try {
                    task.run()
                    future.complete(null)
                    return@launch
                } catch (e: Throwable) {
                    lastError = e
                    delay(100)
                }
            }
            future.completeExceptionally(lastError ?: RuntimeException("Retry failed (unknown error)"))
        }

        return future
    }
}