package com.example.tetrisgame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.activity.OnBackPressedCallback
import com.example.tetrisgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var gameViewModel: GameViewModel
    private lateinit var tetrisView: TetrisView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameViewModel = ViewModelProvider(this)[GameViewModel::class.java]
        
        setupGame()
        setupObservers()
        setupControls()
        setupBackPress()
    }

    private fun setupGame() {
        tetrisView = binding.tetrisView
        tetrisView.setGameViewModel(gameViewModel)
    }

    private fun setupObservers() {
        gameViewModel.score.observe(this) { score ->
            binding.scoreText.text = "Score: $score"
        }

        gameViewModel.level.observe(this) { level ->
            binding.levelText.text = "Level: $level"
        }

        gameViewModel.lines.observe(this) { lines ->
            binding.linesText.text = "Lines: $lines"
        }

        gameViewModel.isGameOver.observe(this) { isGameOver ->
            if (isGameOver) {
                binding.gameOverLayout.visibility = View.VISIBLE
                binding.pauseButton.isEnabled = false
            } else {
                binding.gameOverLayout.visibility = View.GONE
                binding.pauseButton.isEnabled = true
            }
        }

        gameViewModel.isPaused.observe(this) { isPaused ->
            binding.pauseButton.text = if (isPaused) "Resume" else "Pause"
        }
    }

    private fun setupControls() {
        binding.leftButton.setOnClickListener {
            gameViewModel.moveLeft()
        }

        binding.rightButton.setOnClickListener {
            gameViewModel.moveRight()
        }

        binding.rotateButton.setOnClickListener {
            gameViewModel.rotatePiece()
        }

        binding.dropButton.setOnClickListener {
            gameViewModel.dropPiece()
        }

        binding.pauseButton.setOnClickListener {
            gameViewModel.togglePause()
        }

        binding.newGameButton.setOnClickListener {
            gameViewModel.startNewGame()
            binding.gameOverLayout.visibility = View.GONE
        }
    }

    private fun setupBackPress() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Handle back press - pause game or show exit dialog
                if (gameViewModel.isPaused.value == false) {
                    gameViewModel.togglePause()
                } else {
                    finish()
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()
        gameViewModel.pauseGame()
    }

    override fun onResume() {
        super.onResume()
        if (!gameViewModel.isGameOver.value!!) {
            gameViewModel.resumeGame()
        }
    }
} 