 <?php 

    function isConsistent2($record, $number){ 
        for($i = 1, $l = strlen($number);$i < $l;$i++){ 
            $substr = substr($number, 0, $i); 
            if(isset($record[$substr])){ 
                return false; 
            } 
        } 
  
        return true; 
    } 
  
    fscanf(STDIN, '%d',$inputNumber); 
     
    for ($x =0; $x<min($inputNumber, 40); $x++) { 
            fscanf(STDIN, '%d',$numOfPhoneNum); 
            $consistency = true; 
            $coll = array(); 
            $l = min($numOfPhoneNum, 10000); 
            for($y = 0;$y < $l;$y++){ 
                fscanf(STDIN, '%s', $phoneNum); 
                $coll[$phoneNum] = true;            } 
             
            foreach($coll as $phoneNum => $_){ 
                $consistency = $consistency && isConsistent2($coll, $phoneNum); 
            } 
             
            if($consistency){ 
                fprintf(STDOUT, "YES\n"); 
            } else { 
                fprintf(STDOUT, "NO\n"); 
            } 
    }

