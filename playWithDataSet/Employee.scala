package playWithDataSet


//Index,Organization_id,Name,Website,Country,Description,Founded,Industry,no_of_emp



case class Employee(file: String)
{

  val emp = scala.io.Source.fromFile(file)
    .getLines().toList


  val people = emp.map(line => {
    val cols = line.split(",").map(_.trim)
    val format = new java.text.SimpleDateFormat("yyyy-MM-dd")

    val id = cols(0).toInt
    val empName = cols(1)
    val salary = cols(2).toInt
    val empDOB = format.parse(cols(3))
    val empDOJ = format.parse(cols(4))

    EmpData(id,empName,salary,empDOB,empDOJ)


  })


  def displayAllRecords(): Unit ={
    people
      .map(x => s"id: ${x.id}  |empName: ${x.empName}  |salary: ${x.salary}  |empDOB: ${x.empDOB}  |empDOJ: ${x.empDOJ}")
      .foreach(println)
  }

  def distinctRecords(): Unit ={
    people
      .distinct
      .map(x => s"id: ${x.id}  |empName: ${x.empName}  |salary: ${x.salary}  |empDOB: ${x.empDOB}  |empDOJ: ${x.empDOJ}")
      .foreach(println)
  }


  def recordSortedByDOJ(): Unit ={
    people
      .distinct
      .sortBy(_.empDOJ)
      .map(x => s"id: ${x.id}  |empName: ${x.empName}  |salary: ${x.salary}  |empDOB: ${x.empDOB}  |empDOJ: ${x.empDOJ}")
      .foreach(println)
  }




  def recordSortedByDOB(): Unit ={
    people
      .distinct
      .sortBy(_.empDOB)
      .map(x => s"id: ${x.id}  |empName: ${x.empName}  |salary: ${x.salary}  |empDOB: ${x.empDOB}  |empDOJ: ${x.empDOJ}")
      .foreach(println)
  }


  def empAboveAvgSalary(): Unit ={
    val noOfEmp = people.distinct.map(_.salary).size
    val  sumOfAllSalaries = people.distinct.map(_.salary).reduce(_+_)
    val avgSalary = sumOfAllSalaries/noOfEmp

    people
      .distinct
      .filter(_.salary>avgSalary)
      .map(x => s"id: ${x.id}  |empName: ${x.empName}  |salary: ${x.salary}  |empDOB: ${x.empDOB}  |empDOJ: ${x.empDOJ}")
      .foreach(println)

    println("Sum of Salaries: "+sumOfAllSalaries)
    println("No of Employees: "+noOfEmp)
    println("Avg Salary: "+avgSalary)

  }



  def empBelowAvgSalary(): Unit ={
    val noOfEmp = people.distinct.map(_.salary).size
    val  sumOfAllSalaries = people.distinct.map(_.salary).reduce(_+_)
    val avgSalary = sumOfAllSalaries/noOfEmp

    people
      .distinct
      .filter(_.salary<avgSalary)
      .map(x => s"id: ${x.id}  |empName: ${x.empName}  |salary: ${x.salary}  |empDOB: ${x.empDOB}  |empDOJ: ${x.empDOJ}")
      .foreach(println)

    println("Sum of Salaries: "+sumOfAllSalaries)
    println("No of Employees: "+noOfEmp)
    println("Avg Salary: "+avgSalary)

  }





}

