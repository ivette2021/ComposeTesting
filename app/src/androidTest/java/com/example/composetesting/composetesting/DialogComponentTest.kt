package com.example.composetesting.composetesting

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.composetesting.components.AddtaskDialog
import org.junit.Rule
import org.junit.Test

class DialogComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenDialogGetTrue_thenShowDialog(){
        composeTestRule.setContent { 
            AddtaskDialog(show = true, onDismiss = {  }, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("dialog").assertIsDisplayed()
    }

    @Test
    fun whenDialogGetFalse_thenNotShowDialog(){
        composeTestRule.setContent {
            AddtaskDialog(show = false, onDismiss = {  }, onTaskAdded = {})
        }

       // composeTestRule.onNodeWithTag("dialog").assertIsNotDisplayed() //esta no va a funcionar debido a que al estar show en falso nunca existe el if que esta asociado
        composeTestRule.onNodeWithTag("dialog").assertDoesNotExist()
    }
}