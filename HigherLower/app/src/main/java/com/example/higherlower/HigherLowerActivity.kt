package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var currentThrow: Int = 1;
    private var lastThrow: Int = 1;
    private val diceImages = intArrayOf(R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)

        initViews();
    }

    private fun initViews() {
        updateUI();
    }

    private fun updateUI() {
        tvPreviousRoll.text = getString(R.string.last_roll, lastThrow);
        imgDice.setImageResource(diceImages[currentThrow-1]);
    }

    private fun rollDice() {
        lastThrow = currentThrow;
        currentThrow = (1..6).random();
        updateUI();
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show();
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show();
    }

    private fun onHigherClick() {
        rollDice();
        if(currentThrow > lastThrow) {
            onAnswerCorrect();
        } else {
            onAnswerIncorrect();
        }
    }

    private fun onLowerClick() {
        rollDice();
        if(currentThrow < lastThrow) {
            onAnswerCorrect();
        } else {
            onAnswerIncorrect();
        }
    }

    private fun onEqualClick() {
        rollDice();
        if(currentThrow == lastThrow) {
            onAnswerCorrect();
        } else {
            onAnswerIncorrect();
        }
    }
}