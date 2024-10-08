package com.example.bmiviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmiviewmodel.ui.theme.BmiViewmodelTheme
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiViewmodelTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BMICalculatorScreen()
                }
            }
        }
    }
}

@Composable
fun BMICalculatorScreen(viewModel: BMIViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Body Mass Index", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Height field
        OutlinedTextField(
            value = viewModel.height,
            onValueChange = { viewModel.updateHeight(it) },
            label = { Text("Height (m)") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,  // Prevents multiple lines
            colors = OutlinedTextFieldDefaults.colors()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Weight field
        OutlinedTextField(
            value = viewModel.weight,
            onValueChange = { viewModel.updateWeight(it) },
            label = { Text("Weight (kg)") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display calculated BMI
        Text(text = "Body mass index is ${"%.2f".format(viewModel.bmi)}")
    }
}
