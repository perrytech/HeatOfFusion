import java.util.*;

public class Calorimeter
{
    
    public static void main(String[] args){
        
        //var
        
        //main var
        double massCal = 0, massCalCold = 0, massCalColdWarm = 0, massCold = 0, massWarm = 0, tempCold = 0, tempWarm = 0, tempEquil = 0;
        double mass2Cal = 0, mass2CalWarm = 0, mass2CalWarmIce = 0, temp2Warm, temp2Equil = 0;
        
        //equ var
        
        double heatWarm = 0, heatCold = 0, constCal = 0, deltempCal = 0, heatCal = 0, heat2Warm = 0, heatLost = 0, heatMelt = 0;
        
        double mass2Warm = 0, mass2Cold = 0;
        
        double percentError = 0;

        //final double CAPWATER = 4.184;
        
        double HoF = 0;
        
        //end var
        
        //ask for input
        
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter mass of calorimeter: ");
        massCal = reader.nextDouble();
        System.out.println("Enter mass of calorimeter with cold water: ");
        massCalCold = reader.nextDouble();
        System.out.println("Enter mass of calorimeter with cold and warm water: ");
        massCalColdWarm = reader.nextDouble();
        System.out.println("Enter temperature of cold water: ");
        tempCold = reader.nextDouble();
        System.out.println("Enter temperature of warm water: ");
        tempWarm = reader.nextDouble();
        System.out.println("Enter temperature at equilibrium: ");
        tempEquil = reader.nextDouble();
        System.out.println("Enter mass of second calorimeter: ");
        mass2Cal = reader.nextDouble();
        System.out.println("Enter mass of second calorimeter with warm water: ");
        mass2CalWarm = reader.nextDouble();
        System.out.println("Enter mass of second calorimeter with warm water and ice: ");
        mass2CalWarmIce = reader.nextDouble();
        System.out.println("Enter second temperature of warm water: ");
        temp2Warm = reader.nextDouble();
        System.out.println("Enter second temperature at equilibrium: ");
        temp2Equil = reader.nextDouble();
        
        System.out.println("\n\n");
        
        mass2Warm = mass2CalWarm - mass2Cal;
        mass2Cold = mass2CalWarmIce - mass2Cal - mass2Warm;
        
        massCold = massCalCold - massCal;
        massWarm = massCalColdWarm - massCal - massCold;
        
        //detemrine calorimeter constant
        
        heatWarm = massWarm * 4.184 * (tempEquil - tempWarm);
        heatCold = massCold * 4.184 * (tempEquil - tempCold);
        
        constCal = heatWarm - heatCold;
        constCal = (constCal/(tempEquil-tempCold)); //in kJ/g
        
        System.out.print("Calorimeter Constant: " + constCal + " J/g\n\n");
        
        //determine change in cal temp
        
        deltempCal = ((-1)*(mass2Warm) * 4.184 * (temp2Equil-temp2Warm))-(mass2Cold* 4.184 * (temp2Equil - 0));
        
        deltempCal = deltempCal/constCal;
        
        System.out.print("Change in Temp of Calorimeter: " + deltempCal + " *C\n\n");
        
        //determine heats
        
        heatCal = mass2Cal * (constCal) * (deltempCal);
        
        System.out.print("Heat of Calorimeter: " + heatCal + " J\n\n");
        
        heat2Warm = (mass2CalWarmIce - mass2Cal) * 4.184 * (temp2Equil - temp2Warm);
        
        System.out.print("Heat of Warm Water: " + heat2Warm + " J\n\n");
        
        heatLost = constCal * (temp2Equil - temp2Warm);
        
        System.out.print("Heat Lost: " + heatLost + " J\n\n");
        
        heatMelt = (heatLost-heat2Warm + heatCal);
        
        System.out.print("Heat from Melted Ice: " + heatMelt + " J\n\n");
        
        //determine fusion
        
        HoF = heatMelt / (mass2CalWarmIce - mass2Cal);
        
        System.out.print("Heat of Fusion:" + "\n");
        
        System.out.print(HoF + " J/g" + "\n");
        
        HoF = HoF/1000;
        
        System.out.print(HoF + " kJ/g");
        
        percentError = ((Math.abs(0.334 - HoF))/0.334)*100;
        
        System.out.print("\n\nPercent Error: " + percentError + "%");
        
    }
}
