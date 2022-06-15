package com.example.koinsample.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koinsample.repo.Repository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _dataFlow: MutableStateFlow<String> = MutableStateFlow("")
    val dataFlow: StateFlow<String> = _dataFlow.asStateFlow()

    private val _actionFlow: MutableSharedFlow<Action> = MutableSharedFlow()

    init {
        viewModelScope.launch {
            _actionFlow.collectLatest { action ->
                when (action) {
                    is Fetch -> repository.fetch().collectLatest(_dataFlow::emit)
                }
            }
        }
    }

    fun post(action: Action) = viewModelScope.launch { _actionFlow.emit(action) }
}

interface Action

object Fetch : Action