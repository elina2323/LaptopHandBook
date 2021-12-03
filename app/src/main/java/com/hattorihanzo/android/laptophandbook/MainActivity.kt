package com.hattorihanzo.android.laptophandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.hattorihanzo.android.laptophandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = NotebookAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null



    //private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                adapter.addNotebook(it.data?.getSerializableExtra("notebook") as Notebook)
            }
        }
    }

    private fun init(){

        binding.apply {

            rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))

                /*if (index > 4) index = 0
                val notebook = Notebook(imageIdList[index], "Notebook: $index")
                adapter.addNotebook(notebook)
                index++*/
            }
        }
    }
}