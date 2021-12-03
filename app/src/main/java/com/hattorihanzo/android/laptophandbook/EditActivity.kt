package com.hattorihanzo.android.laptophandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hattorihanzo.android.laptophandbook.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.notebook1
    private val imageIdList  = listOf(
        R.drawable.notebook1,
        R.drawable.notebook2,
        R.drawable.notebook3,
        R.drawable.notebook4,
        R.drawable.notebook5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
        buttonNext.setOnClickListener{
            indexImage++
            if (indexImage > imageIdList.size-1) indexImage = 0
            //Log.d("MyLog", "Index: $indexImage")
            imageId = imageIdList[indexImage]
            imageView2.setImageResource(imageId)
        }
        buttonDone.setOnClickListener{
            val notebook = Notebook(imageId, editTitile.text.toString(), editDescription.text.toString())
            val editIntent = Intent().apply {
                putExtra("notebook", notebook)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}