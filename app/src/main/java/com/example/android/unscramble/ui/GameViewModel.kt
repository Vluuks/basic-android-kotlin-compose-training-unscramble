package com.example.android.unscramble.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    private val _testeroni = "Hoi"

    // Game UI state // Backing property to avoid state updates from other classes
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    // is direct assignment shorthand for get()?
    // or does that only work because it's a flow hence the changing parts are within it, but the encapsulating thing stays constant and can be assigned just once?

    val testeroni: String
        get() = _testeroni
}
