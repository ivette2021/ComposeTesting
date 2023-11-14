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
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import com.example.composetesting.components.ComponentA
import org.junit.Before

import org.junit.Rule
import org.junit.Test
class ComponentATest {
    @get:Rule //creamos una regla para que la clase de test entienda (regla son como configuraciones preparada)
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ComponentA()
        }
    }

    @Test
    fun myFirstTest() {  //los test comienzan en minuscula

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
        composeTestRule.onNodeWithText("ivi")
            .performImeAction()//se refiere al boton que hace salto de linea o boton azul en el teclado o enter
        composeTestRule.onNodeWithText("ivi")
            .performTextInput("hola que tal") //este no permite poner otro parametros como . performClick
        composeTestRule.onNodeWithText("ivi").performTextReplacement("no se que decir")

        //Assertions
        composeTestRule.onNodeWithText("ivette").assertExists()
        composeTestRule.onNodeWithText("ivette").assertDoesNotExist()
        composeTestRule.onNodeWithText("ivette").assertContentDescriptionContains("EADWAD")
        composeTestRule.onNodeWithText("ivette").assertContentDescriptionEquals("EADWAD")
        composeTestRule.onNodeWithText("ivette").assertIsDisplayed() //es visible
        composeTestRule.onNodeWithText("ivette").assertIsNotDisplayed() //no es visible
        composeTestRule.onNodeWithText("ivette").assertIsEnabled()
        composeTestRule.onNodeWithText("ivette").assertIsNotEnabled()
        composeTestRule.onNodeWithText("ivette").assertIsSelected()
        composeTestRule.onNodeWithText("ivette").assertIsNotSelected()
        composeTestRule.onNodeWithText("ivette").assertIsFocused()
        composeTestRule.onNodeWithText("ivette").assertIsOn()
        composeTestRule.onNodeWithText("ivette").assertIsOff()
        composeTestRule.onNodeWithText("ivette")
            .assertTextEquals("") //compruebo que el texto es igual a esto ""
        composeTestRule.onNodeWithText("ivette").assertTextContains("Ivette")

        @Test
        fun whenComponentStart_thenVerifyContentIsA() { //nombre del test esta dividido en dos partes lo que va a pasar y lo que deberia pasar
            composeTestRule.setContent { //este se coloca en todos los test
                ComponentA()
            }
        }
        composeTestRule.onNodeWithText("ivette", ignoreCase = true)
            .assertExists() //saldra psoitivo pero si le agregaramos a ivi una t por ej daria error
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("Ivette")

    }

    @Test
    fun whenName_IsAdded_thenVerifyTextContainGreeting() { //dice:  cuando se incluya o se añada un nombre ,verifica que el texto tenga un saludo o greeting
        composeTestRule.setContent { //este se coloca en todos los test
            ComponentA()
        }
        composeTestRule.onNodeWithTag("textFieldname").performTextClearance() //limpia el text filed
         composeTestRule.onNodeWithTag("textFieldname").performTextInput("Jessica") //coloca esta linea

        //composeTestRule.onNodeWithTag("textFieldname").performTextReplacement("Jessica")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Te llamas Jessica")

    }

}