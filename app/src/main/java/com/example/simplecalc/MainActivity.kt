package com.example.simplecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.simplecalc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val DIVIDE:String = "divide"
    private val MULTIPLY:String = "multiply"
    private val ADD:String = "add"
    private val SUBTRACT:String = "substract"
    private val currentNumberString = "currentNumber"
    private val totalString = "totalString"

    private lateinit var binding: ActivityMainBinding

    var total:Int = 0

    var currentNumber:Int = 0

    var currentFunction:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addButtonListener()

        subtractButtonListener()

        multiplyButtonListener()

        divideButtonListener()

        clearButtonListener()

        equalsButtonListener()


    }

    private fun divideButtonListener() {
        binding.divideButton.setOnClickListener {
            if(total == 0) {
                total += currentNumber
            } else {
                total /= currentNumber
            }

            currentFunction=DIVIDE
            resetNumber(currentNumberString)
            displayTotal(total)
        }
    }

    private fun multiplyButtonListener() {
        binding.multipleButton.setOnClickListener {
            if(total == 0) {
                total += currentNumber
            } else {
                total *= currentNumber
            }
            currentFunction=MULTIPLY
            resetNumber(currentNumberString)
            displayTotal(total)
        }
    }

    private fun subtractButtonListener() {
        binding.subtractButton.setOnClickListener {
            if(total == 0) {
                total += currentNumber
            } else {
                total -= currentNumber
            }

            currentFunction=SUBTRACT
            resetNumber(currentNumberString)
            displayTotal(total)
        }
    }

    private fun equalsButtonListener() {
        binding.equalsButton.setOnClickListener {
            if(currentFunction == ADD){
                total += currentNumber
            } else if(currentFunction == SUBTRACT) {
                total -= currentNumber
            } else if(currentFunction == MULTIPLY) {
                total *= currentNumber
            } else {
                total /= currentNumber
            }

            displayTotal(total)
            resetNumber(currentNumberString)
            resetNumber(totalString)
        }
    }

    private fun clearButtonListener() {
        binding.clearButton.setOnClickListener {
            resetNumber(currentNumberString)
            resetNumber(totalString)
            displayTotal(total)
        }
    }

    private fun addButtonListener() {
        binding.addButton.setOnClickListener {
            total += currentNumber
            currentFunction=ADD
            resetNumber(currentNumberString)
            displayTotal(total)
        }
    }

    fun onClickNumber(view: View) {
        var buttonNumber: Button = findViewById(view.id)
        currentNumber =
            "$currentNumber${buttonNumber.text}".toInt()


        displayTotal(currentNumber)
    }

    private fun displayTotal(number: Int) {
        binding.display.text=number.toString()
    }

    private fun resetNumber(numberToReset : String) {
        if(numberToReset == currentNumberString) {
            currentNumber = 0
        } else if (numberToReset == totalString) {
            total = 0
        }
    }
}