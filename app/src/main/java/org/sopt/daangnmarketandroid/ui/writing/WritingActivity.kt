package org.sopt.daangnmarketandroid.ui.writing

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.sopt.daangnmarketandroid.R
import org.sopt.daangnmarketandroid.databinding.ActivityWritingBinding

class WritingActivity: AppCompatActivity() {
    private lateinit var  binding: ActivityWritingBinding

    private var position = PRICE_NOT_SUGGESTION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getGallery()
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

    private fun getGallery(){
        binding.ivCamera.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = MediaStore.Images.Media.CONTENT_TYPE
            launcher.launch(intent)
        }
    }

    private val launcher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK) {
                val url = it.data?.data
                runCatching {
                    Glide.with(this)
                        .load(url)
                        .apply(RequestOptions().override(90, 90))
                        .into(binding.ivPicture)
                }.onFailure {
                    Toast.makeText(this, "사진 불러오기 실패", Toast.LENGTH_SHORT)
                }
            }
        }
    companion object{
        const val PRICE_SUGGESTION = 1
        const val PRICE_NOT_SUGGESTION = 2
    }
}