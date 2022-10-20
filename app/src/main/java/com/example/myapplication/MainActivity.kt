package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_name : EditText= findViewById(R.id.ed_name)
        val tv_text : TextView = findViewById(R.id.tv_text)
        val tv_name : TextView = findViewById(R.id.tv_name)
        val tv_winner : TextView = findViewById(R.id.tv_winner)
        val tv_mmora : TextView = findViewById(R.id.tv_mmora)
        val tv_cmora : TextView = findViewById(R.id.tv_cmora)
        val btn_scissor : RadioButton = findViewById(R.id.btn_scissor)
        val btn_stone : RadioButton = findViewById(R.id.btn_stone)
        val btn_paper : RadioButton = findViewById(R.id.btn_paper)
        val btn_mora : Button = findViewById(R.id.btn_mora)

        btn_mora.setOnClickListener(
            {
                if (ed_name.length() < 1) tv_text.setText("請輸入玩家姓名") else {
                    tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()))
                    if (btn_scissor.isChecked()) tv_mmora.setText("我方出拳\n剪刀") else if (btn_stone.isChecked()) tv_mmora.setText(
                        "我方出拳\n石頭"
                    ) else tv_mmora.setText("我方出拳\n布")
                    val computer = (Math.random() * 3).toInt()
                    if (computer == 0) tv_cmora.setText("電腦出拳\n剪刀") else if (computer == 1) tv_cmora.setText(
                        "電腦出拳\n石頭"
                    ) else if (computer == 2) tv_cmora.setText("電腦出拳\n布")
                    if (btn_scissor.isChecked() && computer == 2 ||
                        btn_stone.isChecked() && computer == 0 ||
                        btn_paper.isChecked() && computer == 1
                    ) {
                        tv_winner.setText(
                            """
                                勝利者
                                ${ed_name.getText()}
                                """.trimIndent()
                        )
                        tv_text.setText("恭喜你獲勝了!!!")
                    } else if (btn_scissor.isChecked() && computer == 1 ||
                        btn_stone.isChecked() && computer == 2 ||
                        btn_paper.isChecked() && computer == 0
                    ) {
                        tv_winner.setText("勝利者\n電腦")
                        tv_text.setText("可惜，電腦獲勝了!!!")
                    } else {
                        tv_winner.setText("勝利者\n平手")
                        tv_text.setText("平局!!請在試一次")
                    }
                }
            })
    }
}