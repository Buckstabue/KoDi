package com.buckstabue.kodi.example.presentation.feature.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.buckstabue.kodi.example.R
import com.buckstabue.kodi.example.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginView, LoginPresenter>(), LoginView {
    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val screenComponent = createLoginComponent()
        presenter = screenComponent.get()
        loginButton.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()
            presenter.onLoginClicked(username, password)
        }
    }
}
