package JsonReader

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}
import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.fge.jsonschema.core.report.ProcessingReport
import com.github.fge.jsonschema.main.JsonSchemaFactory
import spray.json._

import java.io.File
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.github.fge.jackson.JsonLoader
import spray.json.DefaultJsonProtocol._
import spray.json.JsonFormat

import scala.io.Source




case class myClass(var key:String,var value:String)


  object InventoryDataManagement {


    def displayUsingJsonSchemaComparision(): Boolean ={

      val newFileName = Source.fromFile("/Users/a925791/IdeaProjects/ScalaProject/src/main/scala/JsonReader/ChangedFile1.json").mkString
      val schemaFilePath = Source.fromFile("/Users/a925791/IdeaProjects/ScalaProject/src/main/scala/JsonReader/Schema.json").mkString

      val schemaNode : JsonNode = JsonLoader.fromString(schemaFilePath)
      val jsonAt : JsonNode = new ObjectMapper().readTree(newFileName)

      val jsonSchemaFactory = JsonSchemaFactory.byDefault()
      val jsonSchema = jsonSchemaFactory.getJsonSchema(schemaNode)
      val validationResult : ProcessingReport = jsonSchema.validate(jsonAt)

//      println(validationResult.isSuccess)
      return validationResult.isSuccess

    }


    def displayFilesAndCompare(myMap1: Map[String,myClass],myMap2: Map[String,myClass]): Unit ={

      val keyFormyMap1 = myMap1.map(x => x._1.getClass)
      val keyFor1 = myMap1.map(x => x._1)
      val valueFormyMap1 = myMap1.map(_._2.getClass)

      val keyFormyMap2 = myMap2.map(_._1.getClass)
      val keyFor2 = myMap2.map(x => x._1)
      val valueFormyMap2 = myMap2.map(_._2.getClass)


      if((InventoryDataManagement.displayUsingJsonSchemaComparision() == false)){
        println("Schema dont match")

        if(keyFormyMap1.size != keyFormyMap2.size){
          println("no of keys count dont match")
        }
        else if((keyFormyMap1 != keyFormyMap2) || (keyFor1 != keyFor2))
        {
          println("keys dont match")
        }
        else if(valueFormyMap1 != valueFormyMap2) {
          println("Values data type dont match")
          println()
        }
      }
      else{
        println("Its a match")
      }
    }


    def displayMethod2(myMap1: Map[String,myClass],myMap2: Map[String,myClass]): Unit = {

      val keyFormyMap1 = myMap1.map(x => x._1)
      val valueFormyMap1 = myMap1.map(_._2.getClass)

      val keyFormyMap2 = myMap2.map(x => x._1)
      val valueFormyMap2 = myMap2.map(_._2.getClass)



      val cntOfKeyIn1 = keyFormyMap1.foldLeft(Map.empty[String,Int]){
        (mp , key) => mp + (key -> (mp.getOrElse(key,0)+1))
      }

      val cntOfKeyIn2 = keyFormyMap2.foldLeft(Map.empty[String,Int]){
        (mp , key) => mp + (key -> (mp.getOrElse(key,0)+1))
      }

//      println(keyFormyMap1)
//      println(cntOfKeyIn1)
//      println(keyFormyMap2)
//      println(cntOfKeyIn2)

    }

    def main(args: Array[String]): Unit = {
      val mapper = JsonMapper.builder()
        .addModule(DefaultScalaModule)
        .build()

      val src1 = new File("/Users/a925791/IdeaProjects/ScalaProject/src/main/scala/JsonReader/File.json")
      val src2 = new File("/Users/a925791/IdeaProjects/ScalaProject/src/main/scala/JsonReader/ChangedFile1.json")

      try {
        val myMap1 = mapper.readValue(src1, classOf[Map[String, myClass]]) //mapper.readValue(src, classOf[Inventory])
        val myMap2 = mapper.readValue(src2, classOf[Map[String, myClass]]) //mapper.readValue(src, classOf[Inventory])


        displayFilesAndCompare(myMap1,myMap2)

//        displayMethod2(myMap1,myMap2)



      }
      catch{
        case e: Exception => println(s"Oops Something went wrong -> $e")
      }
    }
  }
