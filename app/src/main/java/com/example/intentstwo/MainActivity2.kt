package com.example.intentstwo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name")
        val te = findViewById<TextView>(R.id.nametoview)
        te.text = name

        val image = findViewById<ImageView>(R.id.imageView)

        name?.lowercase()?.let { lowercaseName ->
            when {
                lowercaseName.contains("sachin") -> image.setImageResource(R.drawable.sachin)
                lowercaseName.contains("rahul") -> image.setImageResource(R.drawable.rahuldravid)
                lowercaseName.contains("dhoni") -> image.setImageResource(R.drawable.dhoni)
                lowercaseName.contains("ronaldo") -> image.setImageResource(R.drawable.ronaldo)
                lowercaseName.contains("virat") -> image.setImageResource(R.drawable.virat)
                lowercaseName.contains("messi") -> image.setImageResource(R.drawable.messi)
            }
        }
//        if (name != null) {
//            if (name.lowercase()?.contains("sachin")!!) {
//                image.setImageResource(R.drawable.sachin)
//            }else if (name.lowercase().contains("rahul")) {
//                image.setImageResource(R.drawable.rahuldravid)
//            }
//        }
    }

    fun replyBack(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("replyKey", "Have i Got it Right ?")
        setResult(RESULT_OK, intent)
        finish()

    }

}