package com.example.bmiviewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class BMIViewModel : ViewModel() {
    var height by mutableStateOf("")
        private set
    var weight by mutableStateOf("")
        private set
    var bmi by mutableStateOf(0.0)
        private set

    fun updateHeight(newHeight: String) {
        height = newHeight
        calculateBMI()
    }

    fun updateWeight(newWeight: String) {
        weight = newWeight
        calculateBMI()
    }

    private fun calculateBMI() {
        val heightValue = height.toDoubleOrNull()
        val weightValue = weight.toDoubleOrNull()

        if (heightValue != null && weightValue != null && heightValue > 0) {
            bmi = weightValue / (heightValue * heightValue)
        } else {
            bmi = 0.0
        }
    }
}
