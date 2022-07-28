package guilhermekunz.com.br.firebaseremoteconfigforceupdate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import guilhermekunz.com.br.firebaseremoteconfigforceupdate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var updateApp: UpdateApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateApp = UpdateApp(this)
    }

    override fun onResume() {
        super.onResume()
        updateApp.check()
    }

}