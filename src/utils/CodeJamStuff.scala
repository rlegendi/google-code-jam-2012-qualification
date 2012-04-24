package utils

object CodeJamStuff {
  // solveFunc: input => output
  def processInputs(name: String, solveFunc: List[String] => List[String], maxTestCases: Int): Unit = {
    for (s <- List("-test.in", "-small-practice.in", "-large-practice.in").map(name + _)) {
      val lines = FileStuff.readStuff("input/" + name + "/" + s, maxTestCases)
      val result = solveFunc(lines)

      println("=== > " + s + " ===============================================")
      result.foreach(println(_))

      FileStuff.writeStuff("output/" + name + "/" + s.replaceAll("in$", "out"), result)
    }
  }
}
