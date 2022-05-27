package guilhermekunz.com.br.firebaseremoteconfigforceupdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import guilhermekunz.com.br.firebaseremoteconfigforceupdate.databinding.ActivityForceUpdateBinding

class ActivityForceUpdate : AppCompatActivity() {

    private lateinit var binding: ActivityForceUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForceUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}