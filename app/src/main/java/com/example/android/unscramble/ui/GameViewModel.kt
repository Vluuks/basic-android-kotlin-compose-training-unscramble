package com.example.android.unscramble.ui

import androidx.lifecycle.ViewModel
import com.example.android.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    private val _testeroni = "Hoi"

    private lateinit var currentWord: String
    private var usedWords: MutableSet<String> = mutableSetOf()


    // Game UI state // Backing property to avoid state updates from other classes
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    // is direct assignment shorthand for get()?
    // or does that only work because it's a flow hence the changing parts are within it, but the encapsulating thing stays constant and can be assigned just once?

    val testeroni: String
        get() = _testeroni

    init {
        resetGame()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())

    }

    private fun resetGame() {
        usedWords.clear()
        currentWord = ""
    }

    private fun greeting(): String = "hallo"
    private fun greetingsList(): List<String> = listOf("test", "123")

    private fun pickRandomWordAndShuffle(): String {
        currentWord = (allWords - usedWords).random()
        usedWords.add(currentWord)
        return shuffleCurrentWord(currentWord)
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        // Scramble the word
        tempWord.shuffle()
        while (String(tempWord).equals(word)) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }


}
