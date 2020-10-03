package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

const val DICE_VALUE = "DiceValue"

class MainActivity : AppCompatActivity() {
    private var diceValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_button.setOnClickListener {
            rollDice()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(DICE_VALUE, diceValue)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        diceValue = savedInstanceState.getInt(DICE_VALUE)
        updateDiceImage()
    }
    private fun rollDice() {
        diceValue = Random.nextInt(6) + 1
        updateDiceImage()
    }

    private fun updateDiceImage() {
        val drawableResource = when (diceValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        dice_image.setImageResource(drawableResource)
    }
}