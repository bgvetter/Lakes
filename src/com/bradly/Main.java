package com.bradly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by sylentbv on 2/8/2017.
 */
public class Main {

    //Use this scanner to read text data that will be stored in String variables
    static Scanner stringScanner = new Scanner(System.in);
    //Use this scanner to read in numerical data that will be stored in int or double variables
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {
        //create the variable to hold the results

        ArrayList<Lake> aLakeList = new ArrayList<>();

        String sContinue="Y";

        while(sContinue.equalsIgnoreCase("Y")) {
            String sInput = "";
            double dSize;
            int iLakeExists=-1;
            //ask for lake name
            System.out.println("Enter a lake to add times for:");
            sInput = stringScanner.next();

            //Check to see if lake exists
            for(int i=0;i<aLakeList.size();i++){
                if (aLakeList.get(i).getLakeName().equalsIgnoreCase(sInput)){
                    //lake name found
                    System.out.println(sInput+" was already added. Times will be added to existing lake.");
                    iLakeExists=i;
                    break;
                }
            }
            if(iLakeExists>=0){
                aLakeList.get(iLakeExists).addRunTime();
            }
            else{
                //ask for lake size
                System.out.println("Enter the size of the lake in Miles:");
                dSize = numberScanner.nextDouble();
                //add new lake
                aLakeList.add(new Lake(dSize,sInput));
                //add run times
                aLakeList.get(aLakeList.size()-1).addRunTime();

            }

            //continue asking for times?
            System.out.println("Continue adding lakes? Y/N");
            sContinue=stringScanner.next();
        }

        double dTotal=0;
        //loop through Lakes
        for(Lake l : aLakeList){
            l.displayLakeInfo();
            //get total for current lake
            double dLakeTotal = l.totalRunTime();
            //a dd to total time
            dTotal+=dLakeTotal;
        }
        System.out.println("Total time so far is " + dTotal + " minutes for all lakes.");
    }
}
