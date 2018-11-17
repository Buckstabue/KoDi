package com.buckstabue.kodi.example.presentation.base

import android.content.Intent
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<VIEW : BaseView, PRESENTER: BasePresenter<VIEW>> : AppCompatActivity(),
    BaseView {
    override fun openScreen(intent: Intent) {
        startActivity(intent)
    }

    protected abstract val presenter: PRESENTER

    override fun onStart() {
        super.onStart()
        presenter.attachView(this as VIEW)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }
}
