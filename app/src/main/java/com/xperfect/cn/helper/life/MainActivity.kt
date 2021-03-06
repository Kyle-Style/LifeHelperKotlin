package com.xperfect.cn.helper.life

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        fun startActivity(context: Context) {
            var intent = Intent(context, MainActivity::class.java);
            context.startActivity(intent)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_drawing_board -> DrawingBoardActivity.startActivity(this)
            R.id.btn_brain_training -> BrainTrainingActivity.startActivity(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListener()
    }

    fun initListener() {
        btn_drawing_board.setOnClickListener(this)
    }
}