package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Random roll when app start
        rollDice()

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            rollDice()
        }
    }

    private fun rollDice() {
        // Create Dice object with 6 sids
        val dice = Dice(6)

        // Roll dice
        val diceRoll = dice.roll()

        // Find ImageView in layout
        val diceImage: ImageView = findViewById(R.id.dice_image)

        // Determine correct drawable resource ID to use
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update ImageView with correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..this.numSides).random()
    }
}

//class AnotherDice(numSides: Int) {
//    private val num: Int = numSides
//
//    fun roll(): Int {
//        return (1..this.num).random()
//    }
//}