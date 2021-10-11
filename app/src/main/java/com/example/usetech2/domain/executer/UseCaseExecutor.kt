package com.example.usetech2.domain.executer

import io.reactivex.Scheduler

interface UseCaseExecutor {
    val scheduler: Scheduler
}