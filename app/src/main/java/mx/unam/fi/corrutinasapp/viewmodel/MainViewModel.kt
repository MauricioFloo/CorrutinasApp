package mx.unam.fi.corrutinasapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")
        private set
    var countTime by mutableStateOf(0)
        private set

    /*fun fetchData(){
        viewModelScope.launch {
            delay(5000)
            resultState = "Respuesta obtenida de la Web"
        }
    }
     */


   var oneCout by mutableStateOf(false)
    fun fetchData() {
       val job = viewModelScope.launch {
            for (i in 1..5) {
                delay(1000)
                countTime = i
            }
           oneCout = true
        }
        if( oneCout ){
            job.cancel()
        }

        viewModelScope.launch {
            delay(5000)
            resultState = "Respuesta obtenida de la Web"
        }
    }

}


