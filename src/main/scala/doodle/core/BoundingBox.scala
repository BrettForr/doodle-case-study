package doodle.core

/**
  * Created by am_dev on 5/2/17.
  */
case class BoundingBox(top: Double, bottom: Double, left: Double, right: Double) {

  def center: (Double, Double) = ((right + left)/2.0, (top + bottom)/2.0)

  def above(that: BoundingBox): BoundingBox = BoundingBox(top, that.bottom, left.min(that.left), right.min(that.right))
  def beside(that: BoundingBox): BoundingBox = BoundingBox(top.max(that.top), bottom.min(that.bottom), left, that.right)
  def on(that: BoundingBox): BoundingBox = BoundingBox(top.max(that.top), bottom.min(that.bottom), left.min(that.left), right.max(that.right))



}
