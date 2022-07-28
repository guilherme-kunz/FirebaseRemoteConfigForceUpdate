package guilhermekunz.com.br.firebaseremoteconfigforceupdate

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import guilhermekunz.com.br.firebaseremoteconfigforceupdate.ForceUpdateUtils.getAppVersion

class UpdateApp(private val activity: FragmentActivity) {

    private val firebaseRemoteConfig by lazy { FirebaseRemoteConfig.getInstance() }

    private val configSettings by lazy {
        FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds((if (BuildConfig.DEBUG) 0 else 3600))
            .build()
    }

    init {
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun check() {
        val appVersion = getAppVersion(activity)
        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(activity) {
            if (it.isSuccessful) {
                val forceUpdate = firebaseRemoteConfig.getBoolean(KEY_FORCE_UPDATE_REQUIRED)
                val currentVersion = firebaseRemoteConfig.getString(KEY_CURRENT_VERSION)
                if (forceUpdate) {
                    if (currentVersion > appVersion) {
                        goToUpdate(activity)
                    }
                }
            }
        }

    }

    private fun goToUpdate(context: Context) =
        activity.startActivity(Intent(context, ActivityForceUpdate::class.java))

    companion object {
        const val KEY_CURRENT_VERSION = "android_force_update_current_version"
        const val KEY_FORCE_UPDATE_REQUIRED = "android_force_update_required"
    }

}