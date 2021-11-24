package kr.hs.dgsw.jobdongsani_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        findViewById<BottomNavigationView>(R.id.bottom_nav).apply {
            setupWithNavController(host.navController)
            bar = this
        }

    }

    fun setBottomNavVisibility(bottomNavFragment: Boolean) {
        if(this::bar.isInitialized) {
            bar.visibility = if(bottomNavFragment) View.VISIBLE else View.GONE
        }
    }
}