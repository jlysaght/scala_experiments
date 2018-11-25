// Start writing your ScalaFiddle code here
trait Creature {
  def useWeapon(): Unit = println("swings fist")
}

class Orc extends Creature {
  override def useWeapon(): Unit = println("swings hammer")
}

class Elf extends Creature {
  override def useWeapon(): Unit = println("shoots bow")
}

class Human extends Creature {
}

trait Iterator[A] {
  def hasNext(): Boolean

  def next(): A
}

class CreatureIterator(creatureList: Array[Creature]) extends Iterator[Creature] {
  private var _current = 0

  override def hasNext(): Boolean = (_current < creatureList.size)

  override def next(): Creature = {
    if (hasNext()) {
      val tempIndex: Int = _current
      _current += 1
      creatureList(tempIndex)
    }
    else null
  }
}

object Creatures extends App {
  val creatures: Array[Creature] = new Array[Creature](3)
  creatures(0) = new Human()
  creatures(1) = new Elf()
  creatures(2) = new Orc()

  val iter = new CreatureIterator(creatures)
  while (iter.hasNext()) {
    iter.next().useWeapon()
  }
}