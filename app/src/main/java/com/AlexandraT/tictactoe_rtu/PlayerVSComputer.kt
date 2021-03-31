package com.AlexandraT.tictactoe_rtu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class PlayerVSComputer : AppCompatActivity() {

    /* I watched this video https://www.youtube.com/watch?v=mesmKyuTWcA and made the base of the game.
    * For Player VS Computer mode I had to implement the computer move by myself. */

    var moveCount = 0
    var winnerExists = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_v_s_computer)

        var buttonList = ArrayList<Button>()

        val btn1 = findViewById<Button>(R.id.btn1)
        buttonList.add(btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        buttonList.add(btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        buttonList.add(btn3)

        val btn4 = findViewById<Button>(R.id.btn4)
        buttonList.add(btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        buttonList.add(btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        buttonList.add(btn6)

        val btn7 = findViewById<Button>(R.id.btn7)
        buttonList.add(btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        buttonList.add(btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        buttonList.add(btn9)

        for (btn: Button in buttonList) {
            setButtonListener(btn, buttonList)
        }

        var btnRestart = findViewById<Button>(R.id.btnRestart)
        btnRestart.setOnClickListener {
            for (btn: Button in buttonList) {
                ResetButtons(btn)
            }
        }
    }

    fun ResetButtons(btn: Button) {
        btn.isEnabled = true
        btn.isClickable = true
        btn.text = "-"
        moveCount = 0
        winnerExists = false
    }

    fun disableButtons(btnList: ArrayList<Button>) {
        for (btn: Button in btnList) {
            btn.isEnabled = false
        }
    }

    fun setButtonListener(btn: Button, btnList: ArrayList<Button>) {

        btn.setOnClickListener {
            btn.text = "X"
            moveCount++
            if (moveCount < 5 && !winnerExists) {
                Thread.sleep(500)
                computerMove(btnList)
            }
            btn.isEnabled = false
            CheckWin("X", btnList)
            CheckWin("O", btnList)
        }
    }

    fun computerMove(btnList: ArrayList<Button>) {
        val randomIndex = (0..8).random()
        computerMakeMove(randomIndex, btnList)
    }

    fun computerMakeMove(index: Int, btnList: ArrayList<Button>) {
        val randomButton = btnList[index]
        if (randomButton.text != "X" && randomButton.text != "O" && randomButton.isEnabled) {
            randomButton.text = "O"
        } else {
            computerMove(btnList)
        }
        randomButton.isEnabled = false
    }

    fun CheckWin(player: String, btnList: ArrayList<Button>) {
        if(btnList[0].text.toString()==btnList[1].text.toString() && btnList[1].text.toString()==btnList[2].text.toString() && btnList[2].text.toString() == player && !winnerExists) {
            Toast.makeText(this@PlayerVSComputer, "Uzvar $player", Toast.LENGTH_LONG).show()
            disableButtons(btnList)
            btnList[0].isEnabled = true
            btnList[0].isClickable = false
            btnList[1].isEnabled = true
            btnList[1].isClickable = false
            btnList[2].isEnabled = true
            btnList[2].isClickable = false
            winnerExists = true
        }
        else if(btnList[3].text.toString()==btnList[4].text.toString() && btnList[4].text.toString()==btnList[5].text.toString() && btnList[5].text.toString() == player && !winnerExists) {
            Toast.makeText(this@PlayerVSComputer, "Uzvar $player", Toast.LENGTH_LONG).show()
            disableButtons(btnList)
            btnList[3].isEnabled = true
            btnList[3].isClickable = false
            btnList[4].isEnabled = true
            btnList[4].isClickable = false
            btnList[5].isEnabled = true
            btnList[5].isClickable = false
            winnerExists = true
        }
        else if(btnList[6].text.toString()==btnList[7].text.toString() && btnList[7].text.toString()==btnList[8].text.toString() && btnList[8].text.toString() == player && !winnerExists) {
            Toast.makeText(this@PlayerVSComputer, "Uzvar $player", Toast.LENGTH_LONG).show()
            disableButtons(btnList)
            btnList[6].isEnabled = true
            btnList[6].isClickable = false
            btnList[7].isEnabled = true
            btnList[7].isClickable = false
            btnList[8].isEnabled = true
            btnList[8].isClickable = false
            winnerExists = true
        }
        else if(btnList[0].text.toString()==btnList[3].text.toString() && btnList[3].text.toString()==btnList[6].text.toString() && btnList[6].text.toString() == player && !winnerExists) {
            Toast.makeText(this@PlayerVSComputer, "Uzvar $player", Toast.LENGTH_LONG).show()
            disableButtons(btnList)
            btnList[0].isEnabled = true
            btnList[0].isClickable = false
            btnList[3].isEnabled = true
            btnList[3].isClickable = false
            btnList[6].isEnabled = true
            btnList[6].isClickable = false
            winnerExists = true
        }
        else if(btnList[1].text.toString()==btnList[4].text.toString() && btnList[4].text.toString()==btnList[7].text.toString() && btnList[7].text.toString() == player && !winnerExists) {
            Toast.makeText(this@PlayerVSComputer, "Uzvar $player", Toast.LENGTH_LONG).show()
            disableButtons(btnList)
            btnList[1].isEnabled = true
            btnList[1].isClickable = false
            btnList[4].isEnabled = true
            btnList[4].isClickable = false
            btnList[7].isEnabled = true
            btnList[7].isClickable = false
            winnerExists = true
        }
        else if(btnList[2].text.toString()==btnList[5].text.toString() && btnList[5].text.toString()==btnList[8].text.toString() && btnList[8].text.toString() == player && !winnerExists) {
            Toast.makeText(this@PlayerVSComputer, "Uzvar $player", Toast.LENGTH_LONG).show()
            disableButtons(btnList)
            btnList[2].isEnabled = true
            btnList[2].isClickable = false
            btnList[5].isEnabled = true
            btnList[5].isClickable = false
            btnList[8].isEnabled = true
            btnList[8].isClickable = false
            winnerExists = true
        }
        else if(btnList[0].text.toString()==btnList[4].text.toString() && btnList[4].text.toString()==btnList[8].text.toString() && btnList[8].text.toString() == player && !winnerExists) {
            Toast.makeText(this@PlayerVSComputer, "Uzvar $player", Toast.LENGTH_LONG).show()
            disableButtons(btnList)
            btnList[0].isEnabled = true
            btnList[0].isClickable = false
            btnList[4].isEnabled = true
            btnList[4].isClickable = false
            btnList[8].isEnabled = true
            btnList[8].isClickable = false
            winnerExists = true
        }
        else if(btnList[2].text.toString()==btnList[4].text.toString() && btnList[4].text.toString()==btnList[6].text.toString() && btnList[6].text.toString() == player && !winnerExists) {
            Toast.makeText(this@PlayerVSComputer, "Uzvar $player", Toast.LENGTH_LONG).show()
            disableButtons(btnList)
            btnList[2].isEnabled = true
            btnList[2].isClickable = false
            btnList[4].isEnabled = true
            btnList[4].isClickable = false
            btnList[6].isEnabled = true
            btnList[6].isClickable = false
            winnerExists = true
        }
        else if ((moveCount == 5) && !winnerExists){
            Toast.makeText(this@PlayerVSComputer, "Neizšķirts!", Toast.LENGTH_LONG).show()
        }
    }
}