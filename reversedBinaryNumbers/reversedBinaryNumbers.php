<?php
define('STDIN',fopen("php://stdin","r"));
define('STDOUT',fopen("php://stdin","W"));
fscanf(STDIN, '%d',$inputNumber);
   
   
   $res= bindec(strrev(decbin($inputNumber)));

   fprintf(STDOUT, "%d\n", $res); 


?>
