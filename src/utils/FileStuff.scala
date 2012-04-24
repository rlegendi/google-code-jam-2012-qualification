package utils
import java.io.PrintWriter

object FileStuff {
  def readStuff(fname: String, maxTestCases: Int): List[String] = {
    val source = scala.io.Source.fromFile(fname)
    val allLines = source.getLines.toList

    val dataLength = allLines.first.toInt

    if (dataLength < 1 || maxTestCases < dataLength) {
      throw new IllegalArgumentException("Data length must be in interval [1, " + maxTestCases + "], was " + dataLength)
    }

    val data = allLines.tail

    if (dataLength != data.size) {
      throw new IllegalArgumentException("Data length does not fit lines in file; dataLength=" + dataLength + ", data.length=" + data.length)
    }

    source.close
    data
  }

  def writeStuff(fname: String, data: List[String]) = {
    val fw = new PrintWriter(fname)
    data.foreach(fw.println(_))
    fw.close()
  }
}
