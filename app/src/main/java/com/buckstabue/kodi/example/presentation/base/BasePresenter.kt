package com.buckstabue.kodi.example.presentation.base

import android.content.Context

abstract class BasePresenter<VIEW : BaseView>(
    protected val context: Context
) {
    protected var view: VIEW? = null
    private var isFirstViewAttach = true

    fun attachView(view: VIEW) {
        this.view = view
        if (isFirstViewAttach) {
            onFirstViewAttach()
        }
        onViewAttach(isFirstViewAttach)
        isFirstViewAttach = false
    }

    protected open fun onFirstViewAttach() {
    }

    protected fun onViewAttach(isFirstViewAttach: Boolean) {
    }

    fun detachView() {
        this.view = null
    }
}
