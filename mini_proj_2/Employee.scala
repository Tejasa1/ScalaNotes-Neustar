package mini_proj_2

object Employee extends App{

  val nonManagers = List(
    NonManager(1,"nm1",20000,103),
    NonManager(2,"nm2",60000,102),
    NonManager(3,"nm3",70000,102),
    NonManager(4,"nm4",30000,103),
    NonManager(5,"nm5",80000,-1)
  )

  val managers = List(
    Manager(101,"m1",100000),
    Manager(102,"m2",400000),
    Manager(103,"m3",200000)
  )


  println("Non - Managers: ")
  println(nonManagers.map(_.display()).mkString("\n"))
  println("\n\n")
  println("Managers: ")
  println(managers.map(_.display()).mkString("\n"))

  println("\n\n")
  val salaryOfManagers = managers.map(_.salary)
  val sumOfManagerSalary = salaryOfManagers.reduce(_+_)
  val avgSalaryOfManagers = sumOfManagerSalary/salaryOfManagers.size
  println("Managers having above average salary:")
  println(managers.filter(m=>m.salary>avgSalaryOfManagers).mkString("\n"))

  println("\n\n")

  val salaryOfNonManagers = nonManagers.map(_.salary)
  val sumOfNonManagerSalary = salaryOfNonManagers.reduce(_ + _)
  val avgSalaryOfNonManagers = sumOfNonManagerSalary / salaryOfNonManagers.size
  println("Non - Managers having above average salary:")
  println(nonManagers.filter(m => m.salary > avgSalaryOfNonManagers).mkString("\n"))

  println("\n\n")
  val managerIDs = managers.map(_.mid)
  val nonManagerWithManager = nonManagers.map(x => if(managerIDs.contains(x.mid))x.name )
  println("Non - Manager with Managers Assigned : ")
  println(nonManagerWithManager.mkString("\n"))

  println("\n\n")

  val nonManagerIDs = nonManagers.map(_.mid)
  println(s"nonManagerIDs : $nonManagerIDs\nMmanagerIDs : $managerIDs ")

  println("\n\n")
  println(nonManagerIDs.map(x => if(managerIDs.contains(x)) x else null))
  println("\n\n")
  println("Non - Managers and their respective Managers:")
  nonManagers.map(x => if(managerIDs.contains(x.mid)) println(s"${x.name} : ${managers.map(y=>if(y.mid == x.mid)y.name else null)}") )


}
