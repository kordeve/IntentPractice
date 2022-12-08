package com.emptymind.intentpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToOtherBtn.setOnClickListener {

            val myIntent = Intent(this, OtherActivity::class.java)
//            Intent로 어디서 출발 / 어디로 도착하는지 정보 설정. => 변수에 저장.
            startActivity(myIntent)

        }

        sendMessageBtn.setOnClickListener {

            val inputMessage = edtMessage.text.toString()

            val myIntent = Intent(this, viewMessageActivity::class.java)

            myIntent.putExtra("sendMessage",inputMessage)

            startActivity(myIntent)


        }
    }
}

// 변수이름 myIntent가 중복되도 정상적 실행.