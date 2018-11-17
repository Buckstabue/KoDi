import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.buckstabue.kodi.example.presentation.base.BaseActivity

class ProfileActivity : BaseActivity<ProfileView, ProfilePresenter>(), ProfileView {
    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, ProfileActivity::class.java)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
