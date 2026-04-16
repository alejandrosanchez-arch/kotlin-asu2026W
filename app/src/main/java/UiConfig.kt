package com.example.kotlin_demo_mobile_app
import android.widget.Button

//UI DSL
class UiConfig {

    //configuration for button
    private var buttonConfig: ButtonConfig? = null
    //run when within ButtonConfig
    fun button(block: ButtonConfig.() -> Unit) {
        val config = ButtonConfig()
        config.block()
        buttonConfig = config
    }
    //apply stored button config to Android Button
    fun applyTo(button: Button){
        buttonConfig?.let {
            button.text = it.text
        }
    }
}
//Button Properties
class ButtonConfig {
    var text: String = ""
}
//Entry for DSL, Creating UiConfig Object
fun uiConfig(block: UiConfig.() -> Unit): UiConfig {
    val config = UiConfig()
    config.block()
    return config
}