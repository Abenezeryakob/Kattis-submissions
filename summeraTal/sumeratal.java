import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class sumera {
    public static void main(String [] args){
        try{
        Scanner input = new Scanner(System.in);
        int numberOfSequence= Integer.valueOf(input.nextLine());
        int numberOfSequence1;
        int sum =0;
        
        String seq ;
        seq =input.nextLine();
        String []inputArray =new String[numberOfSequence];
        int [] inputArray1= new int[numberOfSequence];
        inputArray  = seq.split("\\s+");
        
         for (int i =0 ; i <numberOfSequence ; i++){
             
             inputArray1[i]= Integer.parseInt(inputArray[i]);
             
         }
         Arrays.sort(inputArray1);
         
         
        
        input.close();
        if (numberOfSequence%2 ==0){
             numberOfSequence1 =numberOfSequence/2;
            
            
        }else{
             numberOfSequence1 =(numberOfSequence+1)/2;
            
            
        }
        
        for (int i =1 ; i <=numberOfSequence1 ; i++){
            
            int a1 = (inputArray1[numberOfSequence-i]);
            sum=sum+a1;
           // System.out.println(inputArray[numberOfSequence-i]);
           
            
        }
        
        System.out.println(sum);
        }catch (java.util.InputMismatchException e){
            
            System.exit(1);
        }
    }

}
