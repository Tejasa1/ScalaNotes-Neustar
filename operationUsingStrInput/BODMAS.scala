package operationUsingStrInput

case class BODMAS(){

  //5+(6*9+1)-9+1


  //stackForNums = {add numbers as per the sequence}

  //stackForOps = {low priority doesnt get added above high priority
  // if you get ( then pop out all the ops until you get )
  // }


  /* step1:  stackForNums = top->{5}
             stackForOps = top->{+}
  */

  /* step2:  stackForNums = top->{9,6,5}
             stackForOps = top->{*,(,+}
  */

  /* step3:  stackForNums = top->{1,54,5}          performed ops : 6,9  => 6*9   => 54
             stackForOps = top->{),+,(,+}              removed : *
  */

  /* step4:  stackForNums = top->{55,5}              performed ops : 1,54  => 54+1   => 55
             stackForOps = top->{+}                   removed : ),+,(
  */

  /* step5:  stackForNums = top->{9,55,5}
             stackForOps = top->{-,+}


             stackForNums = top->{46,5}             performed ops : 9,55  => 55-9   => 55
             stackForOps = top->{+}                 removed : -
  */

  /* step5:  stackForNums = top->{1,46,5}
             stackForOps = top->{+,+}

             Remove top two from stackForNums and perform top op in stackForOps

             stackForNums = top->{47,5}          performed ops : 1,46 => 46+1 => 47
             stackForOps = top->{+}              removed : +

             stackForNums = top->{52}          performed ops : 47,5 => 5+47 => 52
             stackForOps = top->{}              removed : +


*/

  /* step5:

             stackForNums = top->{50}
             stackForOps = top->{}

             if    : stackForNums ends up with 1 element
             and   : stackForOps ends up empty
             then  : process is complete and string expr was VALID
             else  :
                      if   : stackForNums ends up with one element
                      and  : stackForOps ends up NOT empty
                      then : process complete and string was INVALID

                      if   : stackForNums ends up with more than one element
                      and  : stackForOps ends up empty/ NOT empty
                      then : process complete and string was INVALID
*/


}
