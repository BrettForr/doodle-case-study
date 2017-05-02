package doodle

import javax.swing.JFrame

object Main extends App {
  import doodle.jvm.Java2DCanvas

  val canvas = Java2DCanvas.canvas
  canvas.panel.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  canvas.circle(0, 0, 500)

  //Spiral.draw(canvas)


  //Circle(1.0).draw(canvas)


}
