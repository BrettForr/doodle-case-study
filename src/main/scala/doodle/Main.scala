package doodle

import javax.swing.JFrame

import doodle.core._
import doodle.example.Spiral

object Main extends App {
  import doodle.jvm.Java2DCanvas

  val canvas = Java2DCanvas.canvas
  canvas.setSize(500, 500)
  canvas.setOrigin(0, 0)

  canvas.panel.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  Rectangle(50, 50).draw(canvas, 200, -100)
  canvas.setStroke(Stroke(1.0, Color.darkBlue, Line.Cap.Round, Line.Join.Round))
  canvas.stroke()





}
