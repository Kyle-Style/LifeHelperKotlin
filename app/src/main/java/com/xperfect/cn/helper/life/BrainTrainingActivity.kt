package com.xperfect.cn.helper.life

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class BrainTrainingActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        fun startActivity(context: Context) {
            var intent = Intent(context, BrainTrainingActivity::class.java);
            context.startActivity(intent)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brain_training)
        initListener()
    }

    fun initListener() {
    }
}