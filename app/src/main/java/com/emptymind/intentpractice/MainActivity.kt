package com.emptymind.intentpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    val REQURST_FOR_NICKNAME = 1005
    //    멤버변수는 class 중괄호 바로 앞에 써 주는 변수

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendMessageBtn.setOnClickListener {

            val inputMessage = edtMessage.text.toString()

            val myIntent = Intent(this, viewMessageActivity::class.java)

            myIntent.putExtra("sendMessage", inputMessage)

            startActivity(myIntent)

        }

        editNicknameBtn.setOnClickListener {

            val myIntent = Intent(this, EditContentActivity::class.java)
            startActivityForResult(myIntent, REQURST_FOR_NICKNAME)
        }

        moveToOtherBtn.setOnClickListener {

            val myIntent = Intent(this, OtherActivity::class.java)
//            Intent로 어디서 출발 / 어디로 도착하는지 정보 설정. => 변수에 저장.
            startActivity(myIntent)

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //돌아온 이유가 닉네임을 받으러 다녀온게 맞는지?
        if(requestCode == REQURST_FOR_NICKNAME){

            //추가질문: 확인을 눌러서 돌아온게 맞는가?
            if(resultCode == Activity.RESULT_OK){

                //실제 첨부된 새 닉네임을 꺼내서 텍스트뷰에 반영
                val newNickname = data?.getStringExtra("nickname")
                nickName.text = newNickname

            }

        }

    }

}


// 변수이름 myIntent가 중복되도 정상적 실행.