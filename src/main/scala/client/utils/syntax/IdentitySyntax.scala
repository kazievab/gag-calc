package client.utils.syntax

import scala.scalajs.js

final private[syntax] class IdentityOps[T](private val entity: T) extends AnyVal {

  @inline
  def applyUndef[A](value: js.UndefOr[A])(f: (T, A) => T): T = value.map(v => f(entity, v)).getOrElse(entity)

  @inline
  def applyOption[A](value: Option[A])(f: (T, A) => T): T = value.map(v => f(entity, v)).getOrElse(entity)

  @inline
  def applyOptionFold[A](value: Option[A])(
    f: (T, A) => T,
    s: T => T
  ): T = value.map(v => f(entity, v)).getOrElse(s(entity))

  @inline
  def applyNonEmpty[A](value: List[A])(f: (T, List[A]) => T): T = if (value.nonEmpty) f(entity, value) else entity

  @inline
  def applyWhen(value: Boolean)(f: T => T): T = if (value) f(entity) else entity

  @inline
  def applyUnless(value: Boolean)(f: T => T): T = applyWhen(!value)(f)

  @inline
  def applyIf(value: Boolean)(
    ifTrue: T => T,
    ifFalse: T => T
  ): T = if (value) ifTrue(entity) else ifFalse(entity)

  @inline
  def applyAlways(f: T => T): T = f(entity)

}

trait IdentitySyntax {
  implicit final def syntaxIdentityOps[T](entity: T): IdentityOps[T] = new IdentityOps(entity)
}

object IdentitySyntax extends IdentitySyntax
