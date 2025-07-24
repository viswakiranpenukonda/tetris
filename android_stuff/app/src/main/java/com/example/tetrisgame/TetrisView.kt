package com.example.tetrisgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.LiveData

class TetrisView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var gameViewModel: GameViewModel? = null
    private val paint = Paint()
    private val cellRect = RectF()
    
    private var cellSize = 0f
    private var boardWidth = 0f
    private var boardHeight = 0f
    private var offsetX = 0f
    private var offsetY = 0f

    private var currentPiece: TetrisPiece? = null
    private var currentX = 0
    private var currentY = 0
    private var gameBoard: Array<Array<Int>> = Array(20) { Array(10) { 0 } }

    fun setGameViewModel(viewModel: GameViewModel) {
        this.gameViewModel = viewModel
        observeGameState()
    }

    private fun observeGameState() {
        gameViewModel?.let { vm ->
            vm.gameBoard.observe(context as MainActivity) { board ->
                gameBoard = board
                invalidate()
            }
            
            vm.currentPiece.observe(context as MainActivity) { piece ->
                currentPiece = piece
                invalidate()
            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        
        // Calculate cell size to fit the board
        val boardCols = 10
        val boardRows = 20
        
        cellSize = minOf(w / boardCols.toFloat(), h / boardRows.toFloat())
        boardWidth = cellSize * boardCols
        boardHeight = cellSize * boardRows
        offsetX = (w - boardWidth) / 2
        offsetY = (h - boardHeight) / 2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        // Draw background
        canvas.drawColor(Color.BLACK)
        
        // Draw grid
        drawGrid(canvas)
        
        // Draw placed pieces
        drawBoard(canvas)
        
        // Draw current piece
        drawCurrentPiece(canvas)
    }

    private fun drawGrid(canvas: Canvas) {
        paint.color = Color.GRAY
        paint.strokeWidth = 1f
        
        // Draw vertical lines
        for (i in 0..10) {
            val x = offsetX + i * cellSize
            canvas.drawLine(x, offsetY, x, offsetY + boardHeight, paint)
        }
        
        // Draw horizontal lines
        for (i in 0..20) {
            val y = offsetY + i * cellSize
            canvas.drawLine(offsetX, y, offsetX + boardWidth, y, paint)
        }
    }

    private fun drawBoard(canvas: Canvas) {
        for (y in gameBoard.indices) {
            for (x in gameBoard[y].indices) {
                if (gameBoard[y][x] != 0) {
                    drawCell(canvas, x, y, gameBoard[y][x])
                }
            }
        }
    }

    private fun drawCurrentPiece(canvas: Canvas) {
        currentPiece?.let { piece ->
            for (y in piece.shape.indices) {
                for (x in piece.shape[y].indices) {
                    if (piece.shape[y][x] != 0) {
                        val boardX = currentX + x
                        val boardY = currentY + y
                        if (boardY >= 0) { // Only draw if piece is visible
                            drawCell(canvas, boardX, boardY, piece.color)
                        }
                    }
                }
            }
        }
    }

    private fun drawCell(canvas: Canvas, x: Int, y: Int, color: Int) {
        cellRect.set(
            offsetX + x * cellSize + 1,
            offsetY + y * cellSize + 1,
            offsetX + (x + 1) * cellSize - 1,
            offsetY + (y + 1) * cellSize - 1
        )
        
        paint.color = color
        paint.style = Paint.Style.FILL
        canvas.drawRect(cellRect, paint)
        
        // Draw border
        paint.color = Color.WHITE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f
        canvas.drawRect(cellRect, paint)
    }

    fun updateCurrentPiecePosition(x: Int, y: Int) {
        currentX = x
        currentY = y
        invalidate()
    }
} 