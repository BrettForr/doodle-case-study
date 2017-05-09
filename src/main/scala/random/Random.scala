package random

/**
  * Created by brett on 5/8/2017.
  */
sealed trait Random[A] {
  def run(rng: scala.util.Random): A = this match {
    case Primitive(f) => f(rng)
    case FlatMap(r, f) => f(r.run(rng)).run(rng)
    case Map(r, f) => f(r.run(rng))
  }

  def map[B](f: A => B): Random[B] = Map(this, f)

  def flatMap[B](f: A => Random[B]): Random[B] = FlatMap(this, f)

  def zip[B](that: Random[B]): Random[(A, B)] = for {
    a <- this
    b <- that
  } yield (a,b)

}
object Random {
  def double: Random[Double] = Primitive(r => r.nextDouble())

  def int: Random[Int] = Primitive(r => r.nextInt())

  def normal: Random[Double] = Primitive(r => r.nextGaussian())

  def always[A](in: A): Random[A] = Primitive(r => in)
}

final case class Primitive[A](f: scala.util.Random => A) extends Random[A]
final case class FlatMap[A, B](random: Random[A], f: A => Random[B]) extends Random[B]
final case class Map[A, B](random: Random[A], f: A => B) extends Random[B]
