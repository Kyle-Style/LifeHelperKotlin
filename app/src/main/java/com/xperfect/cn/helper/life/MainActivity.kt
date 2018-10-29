package com.xperfect.cn.helper.life

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.xperfect.cn.helper.life.widget.DrawingBoard
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_set_paint -> showOrHidePainWidth()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initListener()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> if (handleBack()) return false
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun initView() {
        dbv_main.setType(DrawingBoard.ActionType.Rect)
    }

    private fun initListener() {
        btn_set_paint.setOnClickListener(this)
        seekBar.setOnClickListener { }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                dbv_main.setSize(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                showOrHidePainWidth()
            }
        })
        rg_paint_width.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rbv_point -> dbv_main.setType(DrawingBoard.ActionType.Point)
                R.id.rbv_path -> dbv_main.setType(DrawingBoard.ActionType.Path)
                R.id.rbv_line -> dbv_main.setType(DrawingBoard.ActionType.Line)
                R.id.rbv_rect -> dbv_main.setType(DrawingBoard.ActionType.Rect)
                R.id.rbv_circle -> dbv_main.setType(DrawingBoard.ActionType.Circle)
                R.id.rbv_fill_rect -> dbv_main.setType(DrawingBoard.ActionType.FillEcRect)
                R.id.rbv_fill_circle -> dbv_main.setType(DrawingBoard.ActionType.FilledCircle)
            }
            showOrHidePainWidth()
        }
    }

    private fun handleBack(): Boolean {
        return dbv_main.back()
    }

    private fun showOrHidePainWidth() {
        Toast.makeText(this, "showPainWidth", Toast.LENGTH_SHORT).show()
        lyt_paint_settings.visibility = if (lyt_paint_settings.visibility == View.VISIBLE) View.GONE else View.VISIBLE
    }
}