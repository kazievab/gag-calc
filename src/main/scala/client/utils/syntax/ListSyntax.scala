package client.utils.syntax

final private[syntax] class ListOps[A](
  private val value: List[A]
) {

  def widen[B]: List[B] = value.asInstanceOf[List[B]]

}

trait ListSyntax {

  implicit final def syntaxListOps[A](value: List[A]): ListOps[A] = new ListOps[A](value)

}

object ListSyntax extends ListSyntax
