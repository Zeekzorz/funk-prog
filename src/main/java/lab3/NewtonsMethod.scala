object NewtonsMethod {
  def main(args: Array[String]): Unit = {
    Console.println("sqrt(42) = " + sqrt(42))
    Console.println("sqrt(42)^2 = " + Math.pow(sqrt(42), 2))
  }

  def sqrt(x: Double): Double = sqrtIter(1, x)

  def isGoodEnough(y: Double, x: Double): Boolean = Math.abs(Math.pow(y, 2) - x) < 0.001

  def improve(y: Double, x: Double): Double = (y + x / y) / 2

  def sqrtIter(y: Double, x: Double): Double = if (isGoodEnough(y, x)) y else sqrtIter(improve(y, x), x)
}