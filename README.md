Google Code Jam - 2012 - Qualification Solutions
==================================
A toy project to play with solving the GCJ12 Qualification problems in Scala.

You can [read the problem description][http://code.google.com/codejam/contest/dashboard?c=1460488#s=p1] on the GCJ site.

# Scala-Related Questions #

What is the point of having both `length()` and `size()`?

```scala
println(List("A").length)
println(List("A").size)
```

# For the Typesafe Guys #

A few things I spotted in the Scala IDE.

  // FIXME Quicfix: create def it is unknown, like here if it does not exists
  // lines.foreach( decode(_) )

  // FIXME Show error text not on just the Markers, but the error too. E.g.,
  // lines.foreach( println(decode(_)) )

  // FIXME Bolding TODO/FIXME/etc.
  // FIXME Why is the indentation 2 spaces by default?
  

Hotkeys for Ctrl + Shift + N on the project explorer.

# IDEAS #

## Specs2 ##

* Syntax highlight for should/in/must/etc.

# Some verifier things #

* Warning when return is Unit (or not specified) and last line is a value
