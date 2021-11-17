package org.sopt.daangnmarketandroid.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.daangnmarketandroid.R
import org.sopt.daangnmarketandroid.databinding.ActivityHomeBinding
import org.sopt.daangnmarketandroid.ui.writing.WritingActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewEvent()
        fabClickEvent()

    }

    private fun initViewEvent() {
        val mainFragment = MainFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_product_list, mainFragment)
            .commit()
    }

    private fun fabClickEvent() {
        binding.fab.setOnClickListener {
            val intent = Intent(this, WritingActivity::class.java)
            startActivity(intent)
        }
    }
}