package c

object RecycledNumbers extends Application {
	def rotate(str : String, k : Int) : String = {
	  if (k < 0) {
	    return rotate(str, str.length() + k);
	  }
	  
	  //return rotate( str.substring(str.length - 2) + str.charAt(0), k-1)
	  
	  // An even simpler solution:
	  return str.substring(k) + str.substring(0, k)
	}
	
	def countRotatedEntries(n : Int, m : Int) : String = {
	  for (i <- n to m) {
	    val istr = i.toString()
	    
	    istr.zipWithIndex.map {
	      
	    }
	  }
	  ""
	}
  
	def solve(lines: List[String]): List[String] = {
	  1.to(lines.length).map{
	    x =>
	      val numbers = lines(x-1).split("\\s+").map(_.toInt)
	      assert(2 == numbers.length)
	      val (n, m) = (numbers(0), numbers(1))
	      "Case #" + x + ": " + countRotatedEntries(n, m)
	  }.toList
	}
}
