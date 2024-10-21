package br.edu.ifsp.dmo1.conversormonetario

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), OnClickListener {
    private val DOLLAR_VALUE = 5.50

    private lateinit var inputEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findById()
        configClickListener()
    }

    override fun onClick(v: View) {
        if(v == calculateButton){
            makeConvertion()
        }
    }

    private fun findById() {
        inputEditText = findViewById(R.id.edittext_value)
        calculateButton = findViewById(R.id.button_calculate)
        outputTextView = findViewById(R.id.textview_output)
    }

    private fun configClickListener() {
        calculateButton.setOnClickListener(this)
    }

    private fun makeConvertion() {
        var value = try{
            inputEditText.text.toString().toDouble()
        }catch (e: NumberFormatException){
            0.0
        }
        value = value / DOLLAR_VALUE

        outputTextView.text = "U$ $value"
    }
}