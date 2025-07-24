package com.example.tetrisgame

import kotlin.random.Random

data class TetrisPiece(
    val shape: Array<Array<Int>>,
    val color: Int
) {
    fun rotate(): TetrisPiece {
        val rows = shape.size
        val cols = shape[0].size
        val rotated = Array(cols) { Array(rows) { 0 } }
        
        for (y in 0 until rows) {
            for (x in 0 until cols) {
                rotated[x][rows - 1 - y] = shape[y][x]
            }
        }
        
        return TetrisPiece(rotated, color)
    }

    companion object {
        fun getRandomPiece(): TetrisPiece {
            return when (Random.nextInt(7)) {
                0 -> I_PIECE
                1 -> O_PIECE
                2 -> T_PIECE
                3 -> S_PIECE
                4 -> Z_PIECE
                5 -> J_PIECE
                6 -> L_PIECE
                else -> I_PIECE
            }
        }

        // I-Piece (Cyan)
        val I_PIECE = TetrisPiece(
            arrayOf(
                arrayOf(0, 0, 0, 0),
                arrayOf(1, 1, 1, 1),
                arrayOf(0, 0, 0, 0),
                arrayOf(0, 0, 0, 0)
            ),
            0xFF00FFFF.toInt()
        )

        // O-Piece (Yellow)
        val O_PIECE = TetrisPiece(
            arrayOf(
                arrayOf(1, 1),
                arrayOf(1, 1)
            ),
            0xFFFFFF00.toInt()
        )

        // T-Piece (Purple)
        val T_PIECE = TetrisPiece(
            arrayOf(
                arrayOf(0, 1, 0),
                arrayOf(1, 1, 1),
                arrayOf(0, 0, 0)
            ),
            0xFF800080.toInt()
        )

        // S-Piece (Green)
        val S_PIECE = TetrisPiece(
            arrayOf(
                arrayOf(0, 1, 1),
                arrayOf(1, 1, 0),
                arrayOf(0, 0, 0)
            ),
            0xFF00FF00.toInt()
        )

        // Z-Piece (Red)
        val Z_PIECE = TetrisPiece(
            arrayOf(
                arrayOf(1, 1, 0),
                arrayOf(0, 1, 1),
                arrayOf(0, 0, 0)
            ),
            0xFFFF0000.toInt()
        )

        // J-Piece (Blue)
        val J_PIECE = TetrisPiece(
            arrayOf(
                arrayOf(1, 0, 0),
                arrayOf(1, 1, 1),
                arrayOf(0, 0, 0)
            ),
            0xFF0000FF.toInt()
        )

        // L-Piece (Orange)
        val L_PIECE = TetrisPiece(
            arrayOf(
                arrayOf(0, 0, 1),
                arrayOf(1, 1, 1),
                arrayOf(0, 0, 0)
            ),
            0xFFFFA500.toInt()
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TetrisPiece

        if (!shape.contentDeepEquals(other.shape)) return false
        if (color != other.color) return false

        return true
    }

    override fun hashCode(): Int {
        var result = shape.contentDeepHashCode()
        result = 31 * result + color
        return result
    }
} 