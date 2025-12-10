# Fjørd
So, `fjørd` is game framework for Kotlin.
## ATTENTION:
This is Alpha version and it isn't ended project! For render you can use Compose(prpapred in repository).



---

## Using
For using you just need download this repository. You can configure `build.gradle.kts` if you want. Just start working in `Main.kt`:

```kotlin
package org.fjord.client

import org.fjord.engine.*
import org.fjord.engine.math.Vector2

// For example:

class Player(): MovableObject {
   override fun fixedUpdate(deltaTime: Float) {
        super.fixedUpdate(deltaTime) // Here is your logic
    }
}


fun main() {
  var player = Player(name = "Spiller", id = 1, speed = 150f)

  var running = true
  while (running) {
    if (RawInput.isKeyPressed(Keys.ESC)) {
      running = false
    }

    player.update(1f / 60f)
    player.render()

    Thread.sleep(16)
  }
}
```

---

## Feedback

I'll be very excited, if you send me a suggestion for this engine.

Author: [Elegant Script](ivanus.ershov@gmail.com)
