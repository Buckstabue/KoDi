package com.buckstabue.kodi.example.presentation.feature.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.buckstabue.kodi.example.R
import com.buckstabue.kodi.example.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity<ProfileView, ProfilePresenter>(), ProfileView {
    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, ProfileActivity::class.java)
        }
    }

    override lateinit var presenter: ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val screenComponent = createProfileComponent()
        presenter = screenComponent.get()
        logoutButton.setOnClickListener {
            presenter.onLogoutClick()
        }
    }

    override fun showUserName(userName: String) {
        welcomeText.text = "Welcome $userName. How do you do?"
    }
}
