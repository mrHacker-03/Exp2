package com.example.exp2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val password = findViewById<EditText>(R.id.password)
        val address = findViewById<EditText>(R.id.address)
        val gender = findViewById<RadioGroup>(R.id.gender)
        val age = findViewById<EditText>(R.id.age)
         lateinit var genderI:RadioButton
        gender.setOnCheckedChangeListener{ group,checkedId ->
            genderI = findViewById(checkedId)
        }
        val result = findViewById<TextView>(R.id.result)
        val submit = findViewById<Button>(R.id.submit)

        submit.setOnClickListener {
            val r =  " Name: ${name.text} \n Password: ${password.text} \n Address: ${address.text} \n Gender: ${genderI.text} \n Age: ${age.text}"
            result.text = r
        }


    }
}