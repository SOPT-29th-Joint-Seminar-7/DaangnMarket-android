package org.sopt.daangnmarketandroid.ui.writing

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.daangnmarketandroid.R
import org.sopt.daangnmarketandroid.databinding.ActivityWritingBinding

class WritingActivity: AppCompatActivity() {
    private lateinit var  binding: ActivityWritingBinding

    private var position = PRICE_NOT_SUGGESTION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        terminate()
        priceCheck()
    }

    private fun terminate(){
        with(binding){
            ivBack.setOnClickListener { finish() }
            tvComplete.setOnClickListener { finish() }
        }
    }

    private fun priceCheck(){
        binding.ivSuggestion.setOnClickListener {
            when(position){
                PRICE_NOT_SUGGESTION -> {
                    it.setBackgroundResource(R.drawable.ic_checked_marks)
                    binding.tvPriceSuggestion.setTextColor(Color.parseColor("#1a1a1a"))
                    position = PRICE_SUGGESTION
                }
                PRICE_SUGGESTION -> {
                    it.setBackgroundResource(R.drawable.ic_check_marks)
                    binding.tvPriceSuggestion.setTextColor(Color.parseColor("#dfdfdf"))
                    position = PRICE_NOT_SUGGESTION
                }
            }
        }

    }

    companion object{
        const val PRICE_SUGGESTION = 1
        const val PRICE_NOT_SUGGESTION = 2
    }
}