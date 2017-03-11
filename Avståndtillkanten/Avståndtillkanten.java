
import java.lang.reflect.Array;
import java.util.Scanner;

public class kanten {
    //..............................................................
    public static void printRow(int[] row) {
        for (int i : row) {
            if (i >9){
                String j= ".";
                System.out.print(j);
            }
            else{
            System.out.print(i);
            
            }
        }
        System.out.println();
    }
    //..........................................................
    public static void copy(int metrix[][],int a, int b){
        
        for (int i=0; i<a; i++){
            for(int j=0 ;j<b; j++){
                
                if (a<b||b<a){
                    metrix[i][j]=metrix[a-i-1][b-j-1];
                    metrix[a-i-1][j]=metrix[a-i-1][b-j-1];
                    metrix[i][b-j-1]=metrix[a-i-1][b-j-1];
                    metrix[a-i-1][0]=1;
                    metrix[0][b-j-1]=1;
                    
                    
                    
                }
                metrix[i][j]=metrix[a-i-1][b-j-1];
                metrix[a-i-1][j]=metrix[a-i-1][b-j-1];
                metrix[i][b-j-1]=metrix[a-i-1][b-j-1];
                
            }
        }   
    }   
 //........................................................................
    public static void main (String [] args){
    int a =0;
     int b =0;
    String inputNumber;
    //String inputArray[];
    
    Scanner input = new Scanner(System.in);
    inputNumber = input.nextLine();
    


    input.close();
    String[] inputArray = inputNumber.split("\\s+");
    a =Integer.valueOf(inputArray[0]);
    b =Integer.valueOf(inputArray[1]);
    
    
    
    int y=0;
    int z=1;
    
//...........................................................
    
        int metrix[][] = new int[a][b];
    while(y<b ){
            
    for (int i=1; i<=a; i++ ){
        for (int j =1; j<=b;j++){
            
        metrix[z-1][j-1] =-1*(z-1-i);
         metrix[i-1][y] =-1*(y-j);
         //metrix[i-1][j-1] =b-(y+b-i); 
                                }
                      
                                      }
    
    y++;
    if(y<a){
    z++;
    }else{continue;}               
                                        } 
    copy(metrix, a,b);
    
    for(int[] row : metrix) {
        printRow(row);
    
    }
    
    }
}
