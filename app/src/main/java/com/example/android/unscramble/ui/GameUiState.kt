package com.example.android.unscramble.ui

import kotlinx.coroutines.flow.Flow

data class GameUiState(
    val currentScrambledWord: String = "",
    val isGuessedWordWrong: Boolean = false,
)
