package a

import utils.FileStuff
import java.io.PrintWriter

object CodeTable {
  private val input = "ejp mysljylc kd kxveddknmc re jsicpdrysi " +
    "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd " +
    "de kr kd eoya kw aej tysr re ujdr lkgc jv " +
    "zq"

  private val output = "our language is impossible to understand " +
    "there are twenty six factorial possibilities " +
    "so it is okay if you want to just give up " +
    "qz"
    
  private val codeList = input.zip(output)

  // TODO Any better way to do this? (Verify subset of the result)
  // I'd create a static init block for this or something
  // TODO What does it does here?
  assert(codeList.groupBy(_._1).forall(_._2.distinct.length == 1))

  private val codeTable = Map(codeList: _*)

  println("ABC consists of " + codeTable.size + " character(s)")

  def decode(codedText: String): String = {
    codedText.map(c =>
      if (codeTable.contains(c)) codeTable(c)
      else "<?>").mkString
  }

}

// CHECKME
// If it is a class, I cannot run it with Shift+Alt+X, S
object SpeakingTongues extends Application {
  val lines = FileStuff.readStuff("input/A/A-small-practice.in", 30)
  val result = lines.map(l => lines.findIndexOf(_ == l) + 1 -> l).filter(t => t._2.size <= 100).map(t => "Case #" + t._1 + ": " + CodeTable.decode(t._2))
  FileStuff.writeStuff("output/A/A-small-practive.out", result)
}
