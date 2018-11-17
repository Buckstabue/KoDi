import android.content.Context
import com.buckstabue.kodi.example.LoginActivity
import com.buckstabue.kodi.example.data.SessionGateway
import com.buckstabue.kodi.example.data.UserRepository
import com.buckstabue.kodi.example.presentation.base.BasePresenter

class ProfilePresenter(
    private val sessionGateway: SessionGateway,
    private val userRepository: UserRepository,
    context: Context
) : BasePresenter<ProfileView>(context) {

    fun onLogoutClick() {
        sessionGateway.logout()
        view?.openScreen(LoginActivity.getStartIntent())
    }
}
