package com.example.signin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.signin.R.id.textView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var name = intent.extras?.getString("name")
        var age = intent.extras?.getString("age")
        var gender = intent.extras?.getString("gender")
        var hobby1 = intent.extras?.getString("hobby1")
        var hobby2 = intent.extras?.getString("hobby2")
        Log.i("HomeActivity","data is = "+name)
        val homeTextView: TextView = findViewById(textView)
        homeTextView.setText(name+age+gender+hobby1+hobby2)
    }
}