package com.slade.fxtutorial

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.ImageView
import javafx.scene.transform.Scale

class HelloController {
    @FXML
    lateinit var image1: ImageView

    @FXML
    lateinit var clickMeBtn: Button

    @FXML
    lateinit var welcomeText: Label

    @FXML
    private lateinit var osMenuButton: Button

    @FXML
    private fun onHelloButtonClick() {
        welcomeText.text = "Welcome to JavaFX Application!"
    }

    @FXML
    private fun onOsSelect() {

    }

    @FXML
    private fun onClickMe() {
        when(clickMeBtn.transforms.count()) {
            1 -> clickMeBtn.transforms.clear()
            else ->  clickMeBtn.transforms.add(Scale(3.0, 3.0).apply {
                pivotX = 0.0
                pivotY = 0.0
            })
        }
    }
}