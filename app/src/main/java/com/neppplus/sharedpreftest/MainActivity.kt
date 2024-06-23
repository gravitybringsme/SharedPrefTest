package com.neppplus.sharedpreftest

import android.content.Context
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.neppplus.sharedpreftest.utils.ContextUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val autoLoginCheckBox = findViewById<CheckBox>(R.id.autoLoginCheckBox)
        autoLoginCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->

            // 지금 체크된 상황을 그대로 -> ContextUtil을 이용해 자동로그인 여부로 저장
            ContextUtil.setAutoLogin(this, isChecked)

        }
        // 화면이 만들어지면, 저장된 자동로그인 여부 값을 -> 체크박스에 반영

        autoLoginCheckBox.isChecked = ContextUtil.getAutoLogin(this)

    }
}