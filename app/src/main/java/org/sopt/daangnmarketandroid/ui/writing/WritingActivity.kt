package org.sopt.daangnmarketandroid.ui.writing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.daangnmarketandroid.R
import org.sopt.daangnmarketandroid.databinding.ActivityWritingBinding

class WritingActivity: AppCompatActivity() {
    private lateinit var  binding: ActivityWritingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}