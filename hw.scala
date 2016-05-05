package myScala

import scala.scalajs.js.JSApp
import org.scalajs.dom
import dom.document
import scala.scalajs.js.annotation.JSExport

import scala.scalajs.js._

import com.github.nscala_time.time.Imports._

object Utils extends JSApp {
  def main(): Unit = {
    appendPar(document.body, "Hello World")
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  @JSExport
  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }

  //def addNullToOptionSetList(a: List[Any])= "s"

  @JSExport
  def toUpperCase(s: String) = s.toUpperCase()

  @JSExport
  def toLowerCase(s: String) = s.toLowerCase()


  /**
   * formats string so that first letter is upper case and rest lower case
   */
  @JSExport
  def capitalize(s: String) = s.take(1).toUpperCase()+s.drop(1).toLowerCase

 

  @JSExport
  def addMonths(date: Date, n: Int):Date = {
    date.setMonth(date.getMonth()+n+1)
    date
  }

  @JSExport
  val sampleObject:Dynamic  = Dynamic.literal("foo" -> 42, "bar" -> "foobar")

  @JSExport
  val sampleList = Array(sampleObject)


  @JSExport
  def addPaddingNumber(number: Int):String =  number match{
    case n if n <= 9 => "0"+number
    case a           => a.toString
  }


  @JSExport
  def addNullToOptionSetList(a: Array[Dynamic]) = {
    val b  = Dynamic.literal("name" -> "")

    b+:a
  }

  
  /**
 * finds right line in array given the id and then return the attribute `name`
 * @param extid: external id (ex: 2)
 * @param arr: array to be looked up
 * @param attr: attribute of object to be returned (by defaut `name`)
 */
 @JSExport
  def keyToNameInArray(extId: Int, arr: Array[Dynamic], attr: String = "name") = arr
    .filter(_.id.toString.toInt == extId)
    .map(_.selectDynamic(attr))
    .headOption
    .getOrElse(null)


  /**
   * sums array made of Numbers
   */
  @JSExport
  def sum(arr: Array[Int]): Int = arr.reduce{(a,b) => a +b}


  /**
   * sums attribute of an object when in an array
   * [{id:1}, {id: 2}, {id: 3}] => 6
   * 
   */
  @JSExport
  def sumArrayObject(obj: Array[Dynamic], key: String) = sum(obj.map{x =>
    val f:Int = x.selectDynamic(key).toString.toInt
    f
  })

  /**
   * is object attribute in array
   * @return index
   */
  @JSExport
  def isObjectAttrInArray(k:String, arr: Array[Dynamic], attr: String):Int = arr.zipWithIndex.filter{case (v,i) =>
    true
    }
    .headOption
    .map{_._2}
    .get//OrElse(null)

  @JSExport
  def isObjectInArray(obj: Dynamic, arr: Array[Dynamic]) = {
    val a = Dynamic.literal("a" -> "faa", "b" -> "foo")
    val b = Dynamic.literal("a" -> "faa", "b" -> "foo")

    a.map{x => x}

    //a.name == b.name
  }



  /*arr.zipWithIndex.map{a=> 
    val t = if(obj == a._1) 1 else 0
    Dynamic.literal("a" -> a._1, "b" -> obj, "t" -> t)
  }*/
    //.filter{case (v,i) => v == obj}//.map{_._2}.head


  /**
   *  clone an object without reference
   *  @see  stackoverflow: 122102
   */
   @JSExport
  def clone(a: Dynamic) = a



 
}
