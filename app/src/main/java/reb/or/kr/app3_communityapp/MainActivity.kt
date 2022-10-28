package reb.or.kr.app3_communityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import reb.or.kr.app3_communityapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var currentFragment:Fragment

    // 사용자 정보
    var userId =""
    var userPw=""
    var userNickName=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SystemClock.sleep(1000)
        setTheme(R.style.Theme_App3_CommunityApp)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        fragmentController("login",false,false)
    }

    fun fragmentController(name:String,add:Boolean,animate:Boolean){
        when(name){
            "login"-> {
                currentFragment = LoginFragment()
            }
            "join"->{
                currentFragment=JoinFragment()
            }
            "nick_name"->{
                currentFragment=NickNameFragment()
            }
        }
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.main_container,currentFragment)
        if(add==true){
            trans.addToBackStack(name)
        }
        if(animate==true){
            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        }
        trans.commit()
    }
}