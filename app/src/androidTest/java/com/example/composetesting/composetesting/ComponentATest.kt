package com.example.composetesting.composetesting


import androidx.compose.ui.test.junit4.createComposeRule
import com.example.composetesting.components.ComponentA

import org.junit.Rule
import org.junit.Test

class ComponentATest {
    @get:Rule //creamos una regla para que la clase de test entienda (regla son como configuraciones preparada)
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {  //los test comienzan en minuscula
        composeTestRule.setContent {
            ComponentA()
        }
    }
}