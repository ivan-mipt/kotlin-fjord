package org.fjord.engine

import org.fjord.engine.math.Vector2

object Game {
    fun <T> moveTo(obj: T, to: Vector2) where T : GameObject {
        obj.position = to
    }
}