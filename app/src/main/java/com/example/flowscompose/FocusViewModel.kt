package com.example.flowscompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FocusViewModel:ViewModel() {


    private val messageList = listOf<String>(

        "Apple",
        "Pears",
        "Peach"
    )

    //backing property for state flow.
    private val _myStateFlow = MutableStateFlow("")
    val myStateFlow = _myStateFlow.asStateFlow()

    fun onButtonClick(){
        viewModelScope.launch {
            val message = messageList.random()
            _myStateFlow.emit(message)
        }
    }
}