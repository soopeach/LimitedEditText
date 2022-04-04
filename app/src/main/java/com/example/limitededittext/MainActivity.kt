package com.example.limitededittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.limitededittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            editText.addTextChangedListener(object : TextWatcher {
                var maxText = ""
                override fun beforeTextChanged(pos: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    maxText = pos.toString()
                }
                override fun onTextChanged(pos: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    if(editText.lineCount > 4){
                        Toast.makeText(this@MainActivity,
                            "최대 4줄까지 입력 가능합니다.",
                            Toast.LENGTH_SHORT).show()

                        editText.setText(maxText)
                        editText.setSelection(editText.length())
                        countText.setText("${editText.length()} / 40")
                    } else if(editText.length() > 40){
                        Toast.makeText(this@MainActivity, "최대 40자까지 입력 가능합니다.",
                            Toast.LENGTH_SHORT).show()

                        editText.setText(maxText)
                        editText.setSelection(editText.length())
                        countText.setText("${editText.length()} / 40")
                    } else {
                        countText.setText("${editText.length()} / 40")
                    }
                }
                override fun afterTextChanged(p0: Editable?) {

                }
            })
        }
    }
}