package ru.scapegoats.calc

import android.os.Bundle
import android.os.PersistableBundle
import android.os.PowerManager
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main.*
import java.math.BigInteger
import kotlin.math.pow
import kotlin.math.roundToLong


class Calc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
    }


    var number:Double=0.0
    var prevNumber:Double=0.0
    var clickCount=0

    fun numClick(view: View){

        if(operationState==OperationState.EQUALS){
            number=0.0;
            operationState=OperationState.NONE
        }


        clickCount++

        var bNum = (view as Button).text.toString().toDouble()
        if(commaClicked) {
            bNum=decreaseToDecimal(clickCount,bNum)
        }else {
                number = number * 10.0
        }

        number += bNum



        show(number)
    }

    var commaClicked=false
    fun commaClicked(view: View){
        clickCount=0
        commaClicked=true
    }

    var operationState:OperationState=OperationState.NONE
    fun operationClick(view: View){
        commaClicked=false
        applyOperation()

        val operationType=(view as Button).text.toString()
        when(operationType){
            getString(R.string.bMinus) -> operationState=OperationState.MINUS
            getString(R.string.bMult) -> operationState=OperationState.MULTIPLY
            getString(R.string.bPlus) -> operationState=OperationState.PLUS
            getString(R.string.bDivide) -> operationState=OperationState.DIVIDE
            getString(R.string.bEqual) -> {
                operationState=OperationState.EQUALS
                number+=prevNumber
                show(number)
            }
            getString(R.string.bClear)->{
                operationState=OperationState.NONE
                show(number)
            }
        }
        show(prevNumber)

    }

    fun applyOperation(){
        prevNumber=when(operationState){
            OperationState.MINUS -> prevNumber-number
            OperationState.PLUS -> prevNumber+number
            OperationState.MULTIPLY -> prevNumber*number
            OperationState.DIVIDE -> prevNumber/number
            OperationState.NONE -> {number}
            OperationState.EQUALS->{number}
        }

        number = 0.0
        clickCount=0

    }

    fun show(number:Double){
        //если после запятой 0, дробная часть убирается
        if(number-(number.roundToLong()).toDouble()==0.0){
            display.text=number.roundToLong().toString()
        } else {
            display.text=number.toString()
        }
    }
    fun decreaseToDecimal(power:Int,number: Double):Double{
        var num=number
        for(i in 1..power){
            num /= 10.0
        }
        Log.e("gg","$num")
        return num

    }
}