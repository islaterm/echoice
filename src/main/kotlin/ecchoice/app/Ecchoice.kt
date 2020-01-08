package ecchoice.app

import tornadofx.*

/**
 * Entry point to _Ecchoice_.
 *
 * @author [Ignacio Slater Muñoz](islaterm@gmail.com)
 * @version 1.0.1.1
 * @since 1.0
 */
fun main() {
  launch<Ecchoice>()
}

/**
 * Main view of the ecchoice application.
 */
class Ecchoice : App(MainView::class)

private class MainView : View() {
  override val root = vbox {
    label("Placeholder")
  }
}