package com.example.composetesting.composetesting


import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
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


        //Finders
        composeTestRule.onNodeWithText(
            "ivette",
            ignoreCase = true
        )//como este parametroe sta en minuscula agregamos ingnorar caso
        composeTestRule.onAllNodesWithTag("component 2")
        composeTestRule.onNodeWithContentDescription("sImage")//traemos un una imagen induvudual por su id

        composeTestRule.onAllNodesWithTag("xsImage") //con esta linea traemos todos las imagenes con el mismo id
        //  composeTestRule.onAllNodesWithText(":") //busca todos los textos que tengan dos puntos
        composeTestRule.onAllNodesWithText("i") //busca todos los textos que tengan i puntos
        composeTestRule.onAllNodesWithContentDescription("decoration") //te busca todos los que tengan como descripcion decoracion
    }
}