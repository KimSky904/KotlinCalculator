package com.cloud.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cloud.calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var number : String? = "0"
    private var mode : String? = ""
    private var isPaste : Boolean = true
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
        binding.btnRemove.setOnClickListener {
            initialAll()
            binding.btnRemove.text = "AC"
        }
        binding.btnNegativePositive.setOnClickListener {
            number = (number?.trim()?.toInt()?.times(-1)).toString()
            updateScreenNumber()
        }
        binding.btnPercent.setOnClickListener {
            isPaste = false
            number = (number?.trim()?.toInt()?.times(0.01)).toString()
            updateScreenNumber()
        }
        binding.btnEqual.setOnClickListener {
            var intNumber = number?.trim()?.toInt()
            when(mode) {
                "add" -> ""
                "sub" -> ""
                "mul" -> ""
                "div" -> ""
            }
        }



    }
    // 화면 숫자 update
    private fun updateScreenNumber(){
        binding.txtScreen.text = number
    }
    // 초기화
    fun initialAll(){
        number = ""
        updateScreenNumber()
    }

    override fun onClick(v: View?) {
        if(!isPaste) number = ""
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
        binding.btnRemove.text = "C"
        updateScreenNumber()
    }

}