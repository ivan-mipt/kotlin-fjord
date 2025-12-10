package org.fjord.engine

import java.awt.KeyboardFocusManager
import java.awt.event.KeyEvent
import java.awt.event.KeyAdapter

object RawInput {
    private val keyStates = BooleanArray(KeyEvent.KEY_LAST + 1)

    init {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
            .addKeyEventDispatcher { event ->
                when(event.id) {
                    KeyEvent.KEY_PRESSED -> {
                        keyStates[event.keyCode] = true
                        onKeyPressed(event)
                    }
                    KeyEvent.KEY_RELEASED -> {
                        keyStates[event.keyCode] = false
                        onKeyReleased(event)
                    }
                }
                false
            }
    }

    fun isKeyPressed(keyCode: Int): Boolean = keyStates[keyCode]
    fun isKeyPressed(char: Char): Boolean = isKeyPressed(KeyEvent.getExtendedKeyCodeForChar(char.code))

    private var onKeyPressed: (KeyEvent) -> Unit = {}
    private var onKeyReleased: (KeyEvent) -> Unit = {}
}