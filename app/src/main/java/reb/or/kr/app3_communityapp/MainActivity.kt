package reb.or.kr.app3_communityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import reb.or.kr.app3_communityapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SystemClock.sleep(1000)
        setTheme(R.style.Theme_App3_CommunityApp)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}