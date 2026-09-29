package com.assistantmunna.ai

import android.app.Activity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var input: EditText
    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.input)
        status = findViewById(R.id.status)

        findViewById<Button>(R.id.send).setOnClickListener {
            val text = input.text.toString().trim()
            if (text.isNotEmpty()) {
                status.text = "আপনি: $text\n\nV17 প্রস্তুত। AI provider/API যুক্ত করলে online AI উত্তর দিতে পারবে।"
            }
        }

        findViewById<Button>(R.id.voice).setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "bn-BD")
            startActivityForResult(intent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK) {
            val results = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if (!results.isNullOrEmpty()) input.setText(results[0])
        }
    }
}
