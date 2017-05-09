/**
  * Created by am_dev on 5/9/17.
  */
sealed trait BStream[A] {
  import Stream._

  def runFold[B](zero: B)(f: (B, A) => B): B = this match {
    case FromIterator(s) => ???
    case Map(s, f) => ???
    case FlatMap(s, f) => ???
    case Zip(l, r) => ???

  }

  def map[B](f: A => B): BStream[B] = Map(this, f)
  def flatMap[B](f: A => BStream[B]): BStream[B] = FlatMap(this, f)

}
final case class Map[A, B](s: BStream[A], f: A => B) extends BStream[B]
final case class FlatMap[A, B](s: BStream[A], f: A => BStream[B]) extends BStream[B]
final case class FromIterator[A](source: Iterator[A]) extends BStream[A]
final case class Zip[A, B](left: BStream[A], right: BStream[B]) extends BStream[(A,B)]

