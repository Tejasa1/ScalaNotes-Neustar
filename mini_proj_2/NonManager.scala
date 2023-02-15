package mini_proj_2

case class NonManager(nid:Int, name:String, salary:Int, mid:Int){
  def display() = s"$nid  $name  $salary  $mid"
}
