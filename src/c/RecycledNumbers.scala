package c

object RecycledNumbers extends Application {
	def solve(lines: List[String]): List[String] = {
	  1.to(lines.length).map(
	    x => "  "
	  ).toList
	}
}
