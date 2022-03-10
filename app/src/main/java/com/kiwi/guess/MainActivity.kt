package com.kiwi.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.kiwi.guess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private val TAG = ActivityMainBinding::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    val game = NumberGame()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun guess(view: View) {

        val num = binding.edGuess.text.toString().toInt()

        AlertDialog.Builder(this)
            .setTitle("Guess")
            .setMessage(game.guess(num))
            .setPositiveButton("OK"){ d, w ->
                if(game.end){
                    game.reset()
                }
                updateUI()
            }
            .show()
        updateUI()
    }

    private fun updateUI() {
        binding.tvCounter.text = game.counter.toString()
    }
}