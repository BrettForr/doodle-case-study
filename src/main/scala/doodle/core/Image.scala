package doodle.core

import doodle.backend.Canvas

/**
  * Created by am_dev on 5/2/17.
  */
sealed trait Image {
  def on(that: Image): Image = On(this, that)
  def beside(that: Image): Image = Beside(this, that)
  def above(that: Image): Image = Above(this, that)

  def boundingBox: BoundingBox = this match {
    case Circle(r) => BoundingBox(r, -r, -r, r)
    case Rectangle(w, h) => BoundingBox(h/2, -h/2, -w/2, w/2)
    case Above(t, b) => t.boundingBox above b.boundingBox
    case Beside(l, r) => l.boundingBox beside r.boundingBox
    case On(i, o) => i.boundingBox on o.boundingBox
  }

  def draw(canvas: Canvas, x: Double = 0.0, y: Double = 0.0): Unit = this match {
    case Circle(r) => canvas.circle(x, y, r)
    case Rectangle(w, h) => canvas.rectangle(-w/2.0 + x, h/2.0 + y, w, h)
    case Above(t, b) => ???
    case Beside(l, r) => ???
    case On(i, o) => ???
  }

}
final case class Circle(radius: Double) extends Image
final case class Rectangle(width: Double, height: Double) extends Image
final case class Above(top: Image, bottom: Image) extends Image
final case class Beside(left: Image, right: Image) extends Image
final case class On(inner: Image, outer: Image) extends Image
