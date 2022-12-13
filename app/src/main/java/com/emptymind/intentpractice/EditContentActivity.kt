package com.emptymind.intentpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_content.*


class EditContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_content)


        okBtn.setOnClickListener {

//            입력한 새 닉네임이 뭔지? 변수로 저장.
            val inputNewNickname = newNicknameEdt.text.toString()

//            입력한 닉네임을 가지고 메인으로 복귀.

//            왕복티켓처럼 이전 화면 Intent에서 정보를 입력했으므로 지금 화면 Intent()에는 돌아가기 위한 정보를 입력할 필요가 없다.
//            입력닉네임을 담아주기 위한 용도로만 사용하는 Intent.
            val resultIntent = Intent()
            resultIntent.putExtra("nickname",inputNewNickname)
            setResult(Activity.RESULT_OK,resultIntent)
//            OK버튼 눌림과, 백버튼 (취소) 눌림을 구별해야한다.
            finish()



        }

    }
}