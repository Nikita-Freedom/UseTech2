package com.example.usetech2.data.extractor

import com.example.usetech2.domain.executer.UseCaseExecutor
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class NetworkJobExecutor : UseCaseExecutor {
    override val scheduler: Scheduler
        get() = Schedulers.io()
}