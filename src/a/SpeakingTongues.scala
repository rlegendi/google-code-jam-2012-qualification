package a
import java.io.PrintWriter

object SpeakingTongues extends Application {
  val input = "ejp mysljylc kd kxveddknmc re jsicpdrysi " +
    "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd " +
    "de kr kd eoya kw aej tysr re ujdr lkgc jv " +
    "zq"

  val output = "our language is impossible to understand " +
    "there are twenty six factorial possibilities " +
    "so it is okay if you want to just give up " +
    "qz"

  val codeList = input.zip(output)

  // FIXME Bolding TODO/FIXME/etc.
  // FIXME Why is the indentation 2 spaces by default?
  // TODO Any better way to do this?
  assert(codeList.groupBy(_._1).forall(_._2.distinct.length == 1))

  // Wat?
  //  println(codeList.length)
  //  println(codeList.size)

  val codeTable = Map(codeList: _*)

  println("ABC consists of " + codeTable.size + " character(s)")

  def readData(fname: String): List[String] = {
    val source = scala.io.Source.fromFile(fname)
    val allLines = source.getLines.toList

    val dataLength = allLines.first.toInt

    if (dataLength < 1 || 30 < dataLength) {
      throw new IllegalArgumentException("Data length must be in interval [1, 30], was " + dataLength)
    }

    // HELPME If I write tail() here, it is erroneous
    val data = allLines.tail

    // HELPME But! Here I can write it...
    if (dataLength != data.size) {
      throw new IllegalArgumentException("Data length does not fit lines in file; dataLength=" + dataLength + ", data.length=" + data.length)
    }

    source.close
    data
  }

  def saveResult(fname: String, data: List[String]) = {
    val fw = new PrintWriter(fname)
    data.foreach(fw.println(_))
    fw.close()
  }

  def decode(codedText: String): String = {
    //codedText.map( c => codeTable.get( c ) ).mkString
    codedText.map(c =>
      if (codeTable.contains(c)) codeTable(c)
      else "<?>").mkString
  }

  // FIXME Quicfix: create def it is unknown, like here if it does not exists
  // lines.foreach( decode(_) )

  // FIXME Show error text not on just the Markers, but the error too. E.g.,
  // lines.foreach( println(decode(_)) )

  val lines = readData("input/A/A-small-practice.in")
  //lines.foreach(s => println(decode(s)))

  val result = lines.map(l => lines.findIndexOf(_ == l) + 1 -> l).filter(t => t._2.size <= 100).map(t => "Case #" + t._1 + ": " + decode(t._2))
  //t.filter( s -> s.)

  saveResult("output/A/A-small-practive.out", result)

  //(i, s) => (s.size <= 100)

  //foreach(s => println(decode(s)))

  // HELPME Why this isn't working?
  //lines.foreach( println(decode(_)) ) 
}
