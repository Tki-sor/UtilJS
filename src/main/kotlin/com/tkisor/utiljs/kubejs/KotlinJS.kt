package com.tkisor.utiljs.kubejs

import com.tkisor.utiljs.Utiljs
import kotlinx.coroutines.*
import java.lang.Runnable
import java.util.concurrent.Callable
import java.util.concurrent.CompletableFuture
import java.util.function.Supplier

object KotlinJS {
    @JvmStatic
    fun runBlocking(action: Runnable) {
        kotlinx.coroutines.runBlocking {
            action.run()
        }
    }

    @JvmStatic
    @OptIn(DelicateCoroutinesApi::class)
    fun globalScope(action: Runnable) {
        GlobalScope.launch {
            action.run()
        }
    }

    @JvmStatic
    fun coroutineScope(action: Runnable): CompletableFuture<Void> {
        val future = CompletableFuture<Void>()

        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        scope.launch {
            try {
                action.run()
                future.complete(null)
            } catch (e: Exception) {
                Utiljs.LOGGER.error("Exception while running action", e)
                future.completeExceptionally(e)
            }
        }

        return future
    }

    @JvmStatic
    fun <T> coroutineScopeWithResult(action: Callable<T>): CompletableFuture<T> {
        val future = CompletableFuture<T>()
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
        scope.launch {
            try {
                future.complete(action.call())
            } catch (e: Exception) {
                future.completeExceptionally(e)
            }
        }
        return future
    }
}