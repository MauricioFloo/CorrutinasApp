package mx.unam.fi.corrutinasapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")
        private set
    var countTime by mutableStateOf(0)
        private set

    var countTimetwo by mutableStateOf(0)
        private set

    /*fun fetchData(){
        viewModelScope.launch {
            delay(5000)
            resultState = "Respuesta obtenida de la Web"
        }
    }
     */

    var oneCount by mutableStateOf(false)
        private set

    fun fetchData() {
        viewModelScope.launch {
            for (i in 1..5) {
                delay(1000)
                countTime = i
            }
            oneCount = true
        }


        viewModelScope.launch {
            while(!oneCount){ delay(1000) }
            for (i in 1..10) {
                delay(1000)
                countTimetwo = i
            }
            resultState = "Respuesta de la API o la web"
            countTime = 0
            countTimetwo = 0
            oneCount = false
        }

    }

    fun closeCounters(){
        viewModelScope.coroutineContext.cancelChildren()
        countTime = 0
        countTimetwo = 0
        oneCount = false
    }
}


