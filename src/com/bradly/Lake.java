package com.bradly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by sylentbv on 3/12/2017.
 */
public class Lake {

    private double lakeSize;
    private ArrayList<Double> runTimes;
    private String lakeName;

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public double getLakeSize() {
        return lakeSize;
    }

    public void setLakeSize(double lakeSize) {
        this.lakeSize = lakeSize;
    }

    public String getLakeName() {
        return lakeName;
    }
    //constructor for object
    Lake(double iLakeSize,String iLakeName){
        this.lakeName=iLakeName;
        this.lakeSize=iLakeSize;

        runTimes=new ArrayList<>();
    }
    Lake(String iLakeName){
        this.lakeName=iLakeName;
        this.lakeSize=0;

        runTimes=new ArrayList<>();
    }
    //Add a run time
    public void addRunTime(){

        String sContinue="Y";

        while(sContinue.equalsIgnoreCase("Y")) {
            double dTime;
            System.out.println("How long did you run at " + this.lakeName + " lake? in minutes");
            dTime = numberScanner.nextDouble();
            runTimes.add(dTime);

            System.out.println("Continue adding lake times for "+this.lakeName+"? Y/N");
            sContinue=stringScanner.next();
        }

    }
    //find fastest time for lake
    public double fastestTime(){
        //Get Fastest time
        //Make a copy of the list to keep original intact
        ArrayList<Double> dCopy = runTimes;
        //sort the copy
        Collections.sort(dCopy);
        //get lowest time
        double dMax = dCopy.get(0);

        return dMax;
    }
    //get total time running at lake
    public double totalRunTime(){
        double dTotalTime = 0;

        for(double d:runTimes){
            dTotalTime+=d;
        }

        return dTotalTime;
    }
    //get count of runs
    public int runCount(){
        return runTimes.size();
    }
    //get total distance run at lake
    public double totalRunDistance(){
        return runTimes.size() * lakeSize;
    }
    public void displayLakeInfo(){
        System.out.println("Lake name: "+lakeName+"\n"+
            "   Lake Size (mi): "+lakeSize+"\n"+
            "   Number of times run: "+runCount()+"\n"+
            "   Total run distance: "+totalRunDistance()+"\n"+
            "   Total run time: "+totalRunTime()+"\n"+
            "   Fastest run time: "+fastestTime());
    }
}
