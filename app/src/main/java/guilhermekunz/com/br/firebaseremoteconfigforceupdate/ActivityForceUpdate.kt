package guilhermekunz.com.br.firebaseremoteconfigforceupdate

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import guilhermekunz.com.br.firebaseremoteconfigforceupdate.databinding.ActivityForceUpdateBinding

class ActivityForceUpdate : AppCompatActivity() {

    private lateinit var binding: ActivityForceUpdateBinding

    private val firebaseRemoteConfig by lazy { FirebaseRemoteConfig.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForceUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnUpdate()
    }

    private fun btnUpdate() {
        binding.btnForceUpdate.setOnClickListener {
            val updateUrl = firebaseRemoteConfig.getString(KEY_FORCE_UPDATE_URL)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(updateUrl))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            this.startActivity(intent)
        }
    }

    companion object {
        const val KEY_FORCE_UPDATE_URL = "android_force_update_store_url"
    }

}