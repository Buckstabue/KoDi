package com.buckstabue.kodi.example.presentation.base

abstract class BasePresenter<VIEW : BaseView> {
    protected var view: VIEW? = null

    fun attachView(view: VIEW) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }
}
