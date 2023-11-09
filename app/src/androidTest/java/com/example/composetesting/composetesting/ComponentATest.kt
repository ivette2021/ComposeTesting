package com.example.composetesting.composetesting


import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
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

        //Actions
        composeTestRule.onNodeWithText("ivi", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("i").onFirst().performClick()
        composeTestRule.onNodeWithText("ivi").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeLeft()
            swipeRight()
        }
        composeTestRule.onNodeWithText("ivi").performScrollTo()
       // composeTestRule.onNodeWithText("ivi").performScrollTo().performClick().performTextInput("blah blah") //eejmplo de que algunos se pueden continuar en una linea
        composeTestRule.onNodeWithText("ivi").performImeAction()//se refiere al boton que hace salto de linea o boton azul en el teclado o enter
        composeTestRule.onNodeWithText("ivi").performTextInput("hola que tal") //este no permite poner otro parametros como . performClick
        composeTestRule.onNodeWithText("ivi").performTextReplacement("no se que decir")

        //Assertions
        composeTestRule.onNodeWithText("ivi").assertExists()
        composeTestRule.onNodeWithText("ivi").assertDoesNotExist()
        composeTestRule.onNodeWithText("ivi").assertContentDescriptionContains("EADWAD")
        composeTestRule.onNodeWithText("ivi").assertContentDescriptionEquals("EADWAD")
        composeTestRule.onNodeWithText("ivi").assertIsDisplayed() //es visible
        composeTestRule.onNodeWithText("ivi").assertIsNotDisplayed() //no es visible
        composeTestRule.onNodeWithText("ivi").assertIsEnabled()
        composeTestRule.onNodeWithText("ivi").assertIsNotEnabled()
        composeTestRule.onNodeWithText("ivi").assertIsSelected()
        composeTestRule.onNodeWithText("ivi").assertIsNotSelected()
        composeTestRule.onNodeWithText("ivi").assertIsFocused()
        composeTestRule.onNodeWithText("ivi").assertIsOn()
        composeTestRule.onNodeWithText("ivi").assertIsOff()
        composeTestRule.onNodeWithText("ivi").assertTextEquals("") //compruebo que el texto es igual a esto ""
        composeTestRule.onNodeWithText("ivi").assertTextContains("Ivi")




    }
}