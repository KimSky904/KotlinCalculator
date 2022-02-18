package com.cloud.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cloud.calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var number : String? = ""
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialAll()

        // number onClickListener
        binding.btnOne.setOnClickListener(this)
        binding.btnTwo.setOnClickListener(this)
        binding.btnThree.setOnClickListener(this)
        binding.btnFour.setOnClickListener(this)
        binding.btnFive.setOnClickListener(this)
        binding.btnSix.setOnClickListener(this)
        binding.btnSeven.setOnClickListener(this)
        binding.btnEight.setOnClickListener(this)
        binding.btnNine.setOnClickListener(this)
        binding.btnZero.setOnClickListener(this)
        // symbol onClickListener
        binding.btnRemove.setOnClickListener {}


    }
    // 화면 숫자 update
    private fun updateScreenNumber(){
        binding.txtScreen.text = number
    }

    // 숫자 버튼 눌렸을 경우
    fun numberClicked() {

    }
    // 기호(기능) 버튼 눌렀을 경우
    fun symbolClicked(){

    }
    // 초기화
    fun initialAll(){
        number = ""
        updateScreenNumber()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_one -> number += "1"
            R.id.btn_two -> number += "2"
            R.id.btn_three -> number += "3"
            R.id.btn_four -> number += "4"
            R.id.btn_five -> number += "5"
            R.id.btn_six -> number += "6"
            R.id.btn_seven -> number += "7"
            R.id.btn_eight -> number += "8"
            R.id.btn_nine -> number += "9"
            R.id.btn_zero -> number += "0"
        }
        updateScreenNumber()
    }

}