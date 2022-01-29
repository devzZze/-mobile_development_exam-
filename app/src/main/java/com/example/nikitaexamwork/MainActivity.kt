package com.example.nikitaexamwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.nikitaexamwork.databinding.ActivityMainBinding
import com.example.nikitaexamwork.detail_screen.Detail
import com.example.nikitaexamwork.main_screen.Main

interface SelectSpecificUser{
    fun openDetailScreen()
}
interface BackToMainScreen{
    fun backScreen()
}
class MainActivity : AppCompatActivity(), SelectSpecificUser, BackToMainScreen {

    private lateinit var binding: ActivityMainBinding

    private val mainScreen = Main()
    private val detailScreen = Detail()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        replaceFragment(mainScreen)
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(binding.fragmentContainer.id, fragment)
            transaction.commit()
        }
    }

    override fun openDetailScreen() {
        replaceFragment(detailScreen)
    }

    override fun backScreen() {
        replaceFragment(mainScreen)
    }

}