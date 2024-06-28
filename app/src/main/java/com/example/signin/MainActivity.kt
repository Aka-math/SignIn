package com.example.signin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun submit(view: View) {
        Log.i("MainActivity", "Submit btn clicked")

        val name = findViewById<EditText>(R.id.enterName)
        val password = findViewById<EditText>(R.id.password)
        val age = findViewById<EditText>(R.id.enterAge)
        val male = findViewById<RadioButton>(R.id.male)
        val female = findViewById<RadioButton>(R.id.female)
        val other = findViewById<RadioButton>(R.id.other)
        val hobby1 = findViewById<CheckBox>(R.id.hobby1)
        val hobby2 = findViewById<CheckBox>(R.id.hobby2)

        fun gender(view: View): String{
            var selected: String
            if (male.isChecked()){
                selected = "male"
            }
            else if (female.isChecked()){
                selected = "female"
            }
            else if (other.isChecked()){
                selected = "other"
            }
            else{
                selected = "none"
            }
            return selected
        }

        fun hobbyOne(view: View): String {
            var hob: String? = ""
            if (hobby1.isChecked()){
                hob = "hobby 1"
            }
            return hob.toString()
        }

        fun hobbyTwo(view: View): String {
            var hobb: String? = ""
            if (hobby2.isChecked()){
                hobb = "hobby 2"
            }
            return hobb.toString()
        }

        var hIntent = Intent(this,HomeActivity::class.java)
        hIntent.putExtra("name",name.getText().toString())
        hIntent.putExtra("age",age.getText().toString())
        hIntent.putExtra("gender",gender(view))
        hIntent.putExtra("hobby1",hobbyOne(view))
        hIntent.putExtra("hobby2",hobbyTwo(view))
        startActivity(hIntent)
    }
}