/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 James Moore
 */

import java.util.Scanner;

public class ex20 {

    static final double WITAX = 0.05;
    static final double ECTAX = 0.005;
    static final double DUTAX = 0.004;
    static final double ILTAX = 0.08;

    public static void main(String[] args){
        Scanner inScan = new Scanner(System.in);

        System.out.print("What is the order amount? ");
        double inAmount = roundWholeCent(inScan.nextDouble());
        double subtotal =inAmount;
        double tax;
        boolean giveSub = false;

        System.out.print("What is the state? ");
        String state = inScan.next().toLowerCase();
        if (state.equals("wi") || state.equals("wisconsin")){

            System.out.print("What is your county? ");
            String county = inScan.next().toLowerCase();
            double apTax = WITAX;
            if (county.equals("dunn") ){
                apTax += DUTAX;
            }
            else if (county.equals("eau") ){
                apTax += ECTAX;
            }
            tax = roundWholeCent(inAmount * apTax);
            inAmount += tax;
            giveSub = true;
        }
        else if (state.equals("il") || state.equals("illinois") ){
            tax = roundWholeCent(inAmount * ILTAX);
            inAmount += tax;
            giveSub = true;
        }

        String answer = "";
        if (giveSub){
            answer = String.format("The subtotal is $%.2f.\n", subtotal);
        }
        answer = answer + String.format("The total is $%.2f", inAmount);
        System.out.println(answer);
    }

    public static double roundWholeCent(double value){
        int hold = (int) (value * 1000000);
        return Math.ceil( (hold / 10000.0) ) / 100.0;
    }
           // System.out.printf("The subtotal is $%.2f.\n", inAmount);
}