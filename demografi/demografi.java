import java.util.Arrays;
import java.util.Scanner;
public class population {
    
    public static void main(String[] args){
        
        try{
        Scanner input= new Scanner(System.in);
        int numberOfSeq = input.nextInt();// input antal länder
        String country ="";
        String []inputArray =new String[numberOfSeq];
    
        // loppen som tar strängar med länder och population
        for (int i=0; i<=numberOfSeq;i++){
            
            country = country + input.nextLine()+" ";
        }
        // dela upp stringarna och lägg in länderna och populatonen i var sin array 
        inputArray  =country.split("\\s+");
        
        String [] counPop =new String [inputArray.length/2];// array för alla länder
        Integer [] counPop1 =new Integer [inputArray.length/2];// array för alla populaton
        int x=0;
         for (int i=1; i<inputArray.length-1;i=i+2){
             counPop[x]=inputArray[i];
             counPop1[x]=Integer.parseInt(inputArray[i+1]);
             x++;
           }
         
         // inmatningen för updateringar 
           try{
              int numberOfSeq1 = input.nextInt();//antal updateringar
                String country1 ="";
                String []inputArray1 =new String[numberOfSeq1];
        
                //loppen som tar in updateringarna i form av strängar
            
                for (int i=0; i<=numberOfSeq1;i++){
                    
                    country1 = country1 + input.nextLine()+" ";
                }
                inputArray1  =country1.split("\\s+");
                String [] counPop2 =new String [inputArray1.length/2];//array för länder som ska uppdateringar
                Integer[] counPop3 =new Integer [inputArray1.length/2];//array populations förändring
                
                int index1;
                int y =0;
                // loopen som kollar om det finns flera av samma länder i updateringe och lägger in summan länder /population i var sin array
                 for (int i=1; i<inputArray1.length;i=i+2){
                     // kolla om vi har ett land i arrayen , om true summera poulationen för landet annars lägg in den i var sin array
                     if (Arrays.asList(counPop2).contains(inputArray1[i])){
                         
                           index1 = Arrays.asList(counPop2).indexOf(inputArray1[i]);
                          
                           counPop3[index1]= counPop3[index1]+Integer.valueOf(inputArray1[i+1]) ;
                           
                     }else{
                     counPop2[y]=inputArray1[i];
                     counPop3[y]=Integer.parseInt(inputArray1[i+1]);
                     }
                     y++;
                   }
                 //loopen som summerar updateringen med populations värden .................................
                     String [] counPop4 =new String [inputArray.length/2];
                    Integer[] counPop5 =new Integer [inputArray.length/2];
                    for(int i =0; i<counPop.length; i++){
                    
                         index1 = Arrays.asList(counPop2).indexOf(counPop[i]);
                         if (Arrays.asList(counPop2).contains(counPop[i])){
                            
                             counPop4[i] =counPop[i];
                             counPop5[i]=counPop1[i]+counPop3[index1];
                         }
                         else{ counPop4[i] =counPop[i];
                         counPop5[i]=counPop1[i];}
            
                 }
                 
                 int n = counPop5.length;
                    int temp = 0;
                    String temp1="";
                   // sortera med population buble sort
                    for(int i=0; i < n; i++){
                            for(int j=1; j < (n-i); j++){
                                   
                                    if(counPop5[j-1] <counPop5[j]){
                                            //swap the elements!
                                            temp = counPop5[j-1];
                                            counPop5[j-1] = counPop5[j];
                                            counPop5[j] = temp;
                                            temp1 = counPop4[j-1];
                                            counPop4[j-1] = counPop4[j];
                                            counPop4[j] = temp1;
                                    }
                                   
                            }
                            }
                    
                    

                 // om lika population sortera med alfabetsvis   
                int x1=0;
                while(x1<counPop4.length-1){
                    
                    boolean test =  counPop5[x1] < counPop5[x1+1] || counPop5[x1] > counPop5[x1+1];
                    
                    if(!test){
                        int x2=1;
                        
                        boolean test2 =  counPop5[x1] < counPop5[x1+x2] || counPop5[x1] > counPop5[x1+x2];
                        
                        while(!test2&& (x1+x2)<counPop4.length)
                            {
                            
                    //använ compareTo funktionen för att sortera efter bokstäver
                                if(counPop4[x1+x2].compareTo(counPop4[x1])<0)//if true counPop4[i]<(counPop4[i+1]
                                {   Integer tempint=  counPop5[x1] ;
                                    String tempStr = counPop4[x1];
                                    counPop4[x1] = counPop4[x1+x2];
                                    counPop4[x1+x2] = tempStr;
                                    counPop5[x1] = counPop5[x1+x2];
                                    counPop5[x1+x2] = tempint;
                                    
                                    
                                }
                                
                                x2++;
                                if((x1+x2)<counPop4.length){
                                test2 =  counPop5[x1] < counPop5[x1+x2] || counPop5[x1] > counPop5[x1+x2];}
                        }
                        
                    }
                    x1=x1+1;
                }
                
                //printa utresultat
                for (int i =0; i<counPop5.length ; i++){
                    System.out.println(counPop4[i]+" "+counPop5[i]);
                }//System.out.println(counPop4[counPop4.length-1]+" "+counPop5[counPop5.length-1]);
                    
            input.close();         
           }catch(NumberFormatException ex){System.exit(1);}
         //---------------------------------------------------------------------------------
         }catch (java.util.InputMismatchException e){
                
                System.exit(1);
            }
    
    }
    
    
    

}
