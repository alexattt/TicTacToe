package com.AlexandraT.tictactoe_rtu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOK = findViewById<Button>(R.id.btnOK)
        val btnPVP = findViewById<Button>(R.id.btnPVP)
        val btnPVC = findViewById<Button>(R.id.btnPVC)
        val nameField = findViewById<EditText>(R.id.nameField)
        val helloMsgField = findViewById<TextView>(R.id.helloMsg)
        val chooseField = findViewById<TextView>(R.id.chooseModeText)

        chooseField.isVisible = false
        btnPVP.isVisible = false
        btnPVC.isVisible = false

        btnOK.setOnClickListener {
            var playerName = nameField.text.toString()
            helloMsgField.setText("Welcome to the game $playerName!");
            chooseField.isVisible = true
            btnPVP.isVisible = true
            btnPVC.isVisible = true
        }

        btnPVP.setOnClickListener {
            val intent = Intent(this, PlayerVSPlayer::class.java)
            startActivity(intent)
        }

        btnPVC.setOnClickListener {
            val intentTwo = Intent(this, PlayerVSComputer::class.java)
            startActivity(intentTwo)
        }
    }
}