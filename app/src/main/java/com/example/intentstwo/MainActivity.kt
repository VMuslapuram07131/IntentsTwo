package com.example.intentstwo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var resultlauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        resultlauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == RESULT_OK) {
                val intent = result.data
                val reply = intent?.getStringExtra("replyKey")
                Snackbar.make(findViewById(R.id.main), reply.toString(), Snackbar.LENGTH_SHORT).show()
            }
        }
    }
    fun giveSurprise(view: View) {

        val name = findViewById<TextInputLayout>(R.id.textInputLayout)
        val data = name.editText?.text.toString()
        val intent = Intent(this, MainActivity2::class.java)

        intent.putExtra("name", data)
//        startActivity(intent)

        resultlauncher.launch(intent)

    }
}