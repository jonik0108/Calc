package zadira.mycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        one.setOnClickListener { uppendtext("1") }
        two.setOnClickListener { uppendtext("2") }
        tree.setOnClickListener { uppendtext("3") }
        four.setOnClickListener { uppendtext("4") }
        five.setOnClickListener { uppendtext("5") }
        six.setOnClickListener { uppendtext("6") }
        seven.setOnClickListener { uppendtext("7") }
        eight.setOnClickListener { uppendtext("8") }
        nine.setOnClickListener { uppendtext("9") }
        zero.setOnClickListener { uppendtext("0") }
        dote.setOnClickListener {
            val str = mathoperation.text.toString()
            val last =str.takeLast(1)
            if(last=="."|| last =="-" || last=="*" || last=="/" || last=="+"){
                Toast.makeText(this, "retry", Toast.LENGTH_SHORT).show()
            }else{
                uppendtext(".")
            }
        }
        leftscope.setOnClickListener { uppendtext("(") }
        rightscope.setOnClickListener { uppendtext(")") }

        del.setOnClickListener {
            val str = mathoperation.text.toString()
            val last =str.takeLast(1)
            if(last=="/"|| last =="-" || last=="*" || last=="+" || last=="."){
                Toast.makeText(this, "retry", Toast.LENGTH_SHORT).show()
            }else{
                uppendtext("/")
            }
        }
        mult.setOnClickListener {
            val str = mathoperation.text.toString()
            val last =str.takeLast(1)
            if(last=="*"|| last =="-" || last=="+" || last=="/" || last=="."){
                Toast.makeText(this, "retry", Toast.LENGTH_SHORT).show()
            }else{
                uppendtext("*")
            }
        }
        minus.setOnClickListener {
            val str = mathoperation.text.toString()
            val last =str.takeLast(1)
            if(last=="-"|| last =="+" || last=="*" || last=="/" || last=="."){
                Toast.makeText(this, "retry", Toast.LENGTH_SHORT).show()
            }else{
                uppendtext("-")
            }
        }
        plus.setOnClickListener {
            val str = mathoperation.text.toString()
            val last =str.takeLast(1)
            if(last=="+" || last =="-" || last=="*" || last=="/" || last=="."){
                Toast.makeText(this, "retry", Toast.LENGTH_SHORT).show()
            }else{
                uppendtext("+")
            }
        }
        ac.setOnClickListener {
            mathoperation.text=""
            result_text.text=""
        }
        back.setOnClickListener {
            var str=mathoperation.text.toString()
            if (str.isNotEmpty())
                mathoperation.text=str.substring(0,str.length-1)
            result_text.text=""

        }
        equal.setOnClickListener {
            try {
                val ex= ExpressionBuilder(mathoperation.text.toString()).build()
                val result=ex.evaluate()
                val longRes=result.toLong()
                if (result==longRes.toDouble())
                {
                    result_text.text=longRes.toString()
                }else{
                    result_text.text=result.toString()
                }

            }catch (e: Exception){
                Log.d("Eror", "message:${e.message}")
            }
        }



    }
    fun uppendtext(str: String){
        if (result_text.text!=""){
            mathoperation.text=result_text.text
            result_text.text=""
        }
        mathoperation.append(str)
    }
}