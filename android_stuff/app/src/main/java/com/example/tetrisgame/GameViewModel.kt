package com.example.tetrisgame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class GameViewModel : ViewModel() {
    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _level = MutableLiveData(1)
    val level: LiveData<Int> = _level

    private val _lines = MutableLiveData(0)
    val lines: LiveData<Int> = _lines

    private val _isGameOver = MutableLiveData(false)
    val isGameOver: LiveData<Boolean> = _isGameOver

    private val _isPaused = MutableLiveData(false)
    val isPaused: LiveData<Boolean> = _isPaused

    private val _gameBoard = MutableLiveData(Array(20) { Array(10) { 0 } })
    val gameBoard: LiveData<Array<Array<Int>>> = _gameBoard

    private val _currentPiece = MutableLiveData<TetrisPiece>()
    val currentPiece: LiveData<TetrisPiece> = _currentPiece

    private val _nextPiece = MutableLiveData<TetrisPiece>()
    val nextPiece: LiveData<TetrisPiece> = _nextPiece

    private var gameJob: Job? = null
    private val gameScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private var dropSpeed = 1000L // milliseconds
    private var currentX = 3
    private var currentY = 0

    init {
        startNewGame()
    }

    fun startNewGame() {
        _score.value = 0
        _level.value = 1
        _lines.value = 0
        _isGameOver.value = false
        _isPaused.value = false
        _gameBoard.value = Array(20) { Array(10) { 0 } }
        
        generateNewPiece()
        startGameLoop()
    }

    private fun generateNewPiece() {
        if (_nextPiece.value == null) {
            _nextPiece.value = TetrisPiece.getRandomPiece()
        }
        
        _currentPiece.value = _nextPiece.value
        _nextPiece.value = TetrisPiece.getRandomPiece()
        
        currentX = 3
        currentY = 0
        
        if (!isValidMove(currentX, currentY, _currentPiece.value!!)) {
            _isGameOver.value = true
            stopGameLoop()
        }
    }

    fun moveLeft() {
        if (_isPaused.value == true || _isGameOver.value == true) return
        
        if (isValidMove(currentX - 1, currentY, _currentPiece.value!!)) {
            currentX--
            notifyBoardChanged()
        }
    }

    fun moveRight() {
        if (_isPaused.value == true || _isGameOver.value == true) return
        
        if (isValidMove(currentX + 1, currentY, _currentPiece.value!!)) {
            currentX++
            notifyBoardChanged()
        }
    }

    fun rotatePiece() {
        if (_isPaused.value == true || _isGameOver.value == true) return
        
        val rotatedPiece = _currentPiece.value!!.rotate()
        if (isValidMove(currentX, currentY, rotatedPiece)) {
            _currentPiece.value = rotatedPiece
            notifyBoardChanged()
        }
    }

    fun dropPiece() {
        if (_isPaused.value == true || _isGameOver.value == true) return
        
        while (isValidMove(currentX, currentY + 1, _currentPiece.value!!)) {
            currentY++
        }
        placePiece()
    }

    fun togglePause() {
        if (_isGameOver.value == true) return
        
        if (_isPaused.value == true) {
            resumeGame()
        } else {
            pauseGame()
        }
    }

    fun pauseGame() {
        _isPaused.value = true
        stopGameLoop()
    }

    fun resumeGame() {
        _isPaused.value = false
        startGameLoop()
    }

    private fun startGameLoop() {
        if (gameJob?.isActive == true) return
        
        gameJob = gameScope.launch {
            while (isActive && !_isPaused.value!! && !_isGameOver.value!!) {
                delay(dropSpeed)
                if (!_isPaused.value!! && !_isGameOver.value!!) {
                    if (isValidMove(currentX, currentY + 1, _currentPiece.value!!)) {
                        currentY++
                        notifyBoardChanged()
                    } else {
                        placePiece()
                    }
                }
            }
        }
    }

    private fun stopGameLoop() {
        gameJob?.cancel()
    }

    private fun placePiece() {
        val piece = _currentPiece.value!!
        val board = _gameBoard.value!!
        
        for (y in 0 until piece.shape.size) {
            for (x in 0 until piece.shape[y].size) {
                if (piece.shape[y][x] != 0) {
                    val boardY = currentY + y
                    val boardX = currentX + x
                    if (boardY >= 0 && boardY < board.size && boardX >= 0 && boardX < board[0].size) {
                        board[boardY][boardX] = piece.color
                    }
                }
            }
        }
        
        _gameBoard.value = board
        clearLines()
        generateNewPiece()
        notifyBoardChanged()
    }

    private fun clearLines() {
        val board = _gameBoard.value!!
        var linesCleared = 0
        
        for (y in board.size - 1 downTo 0) {
            if (board[y].all { it != 0 }) {
                // Move all lines above down
                for (moveY in y downTo 1) {
                    board[moveY] = board[moveY - 1].clone()
                }
                board[0] = Array(board[0].size) { 0 }
                linesCleared++
            }
        }
        
        if (linesCleared > 0) {
            _lines.value = _lines.value!! + linesCleared
            _score.value = _score.value!! + (linesCleared * 100 * _level.value!!)
            
            // Level up every 10 lines
            if (_lines.value!! % 10 == 0) {
                _level.value = _level.value!! + 1
                dropSpeed = maxOf(100L, dropSpeed - 100L) // Increase speed
            }
        }
    }

    private fun isValidMove(newX: Int, newY: Int, piece: TetrisPiece): Boolean {
        val board = _gameBoard.value!!
        
        for (y in 0 until piece.shape.size) {
            for (x in 0 until piece.shape[y].size) {
                if (piece.shape[y][x] != 0) {
                    val boardY = newY + y
                    val boardX = newX + x
                    
                    if (boardX < 0 || boardX >= board[0].size || 
                        boardY >= board.size || 
                        (boardY >= 0 && board[boardY][boardX] != 0)) {
                        return false
                    }
                }
            }
        }
        return true
    }

    private fun notifyBoardChanged() {
        _gameBoard.value = _gameBoard.value
    }

    override fun onCleared() {
        super.onCleared()
        stopGameLoop()
        gameScope.cancel()
    }
} 