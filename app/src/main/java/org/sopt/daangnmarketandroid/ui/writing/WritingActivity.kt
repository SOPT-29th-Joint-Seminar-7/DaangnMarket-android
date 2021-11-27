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
import org.sopt.daangnmarketandroid.api.ServiceCreator
import org.sopt.daangnmarketandroid.databinding.ActivityWritingBinding
import org.sopt.daangnmarketandroid.util.enqueueUtil
import org.sopt.daangnmarketandroid.ui.writing.data.RequestWriteData

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
            tvComplete.setOnClickListener { completePost() }
        }
    }

    private fun completePost(){
        val title = binding.etTitle.text.toString()
        val category = "스포츠/레저"
        val price = binding.etPrice.text.toString().toInt()

        val state = when {
            binding.chUsed.isChecked -> {
                "중고"
            }
            binding.chNoneOpen.isChecked -> {
                "미개봉"
            }
            binding.chGood.isChecked -> {
                "상태양호"
            }
            binding.chBad.isChecked -> {
                "하자약간"
            }
            else -> {
                "중고"
            }
        }

        val trade = when {
            binding.chPace.isChecked -> {
                "대면"
            }
            else -> {
                "배달"
            }
        }
        val content = binding.etContent.text.toString()

        val requestWriteData = RequestWriteData(
            title = title,
            category = category,
            price = price,
            state = state,
            trade = trade,
            content = content
        )

        val call = ServiceCreator.apiService.postUpload(requestWriteData)

        call.enqueueUtil(
            onSuccess = {
                Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
            }
        )
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