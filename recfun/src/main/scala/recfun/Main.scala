package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
		  if (r == 0 || c == 0 || r == c) 1
			else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
		  def helper(chars: List[Char], counter: Int): Boolean = {
			  if (counter < 0) false
				else if (chars.isEmpty) counter == 0
				else if (chars.head == '(') helper(chars.tail, counter + 1)
				else if (chars.head == ')') helper(chars.tail, counter - 1)
				else helper(chars.tail, counter)
      }

			helper(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty || money < 0) 0
			else if (money == 0) 1
			else countChange(money, coins.tail) +
			       countChange(money - coins.head, coins)
    }
  }
