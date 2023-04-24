package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Patient patient1 = new Patient("Brad", 21,
                new Eye("Left eye", "Short sighted", "blue", true),
                new Eye("Right eye", "Normal", "blue", true),
                new Stomach("Stomach", "PUD", true),
                new Heart("Heart", "Normal", 65),
                new Skin("Skin", "Burned", "White", 40));

        System.out.println("Name: " + patient1.getName());
        System.out.println("Age: " + patient1.getAge());

        Scanner input = new Scanner(System.in);
        boolean shouldFinish = false;

        while(!shouldFinish) {
            System.out.println("Choose an organ:" +
                    "\n\t1.Left Eye" +
                    "\n\t2.Right Eye" +
                    "\n\t3.Stomach" +
                    "\n\t4.Heart" +
                    "\n\t5.Skin" +
                    "\n\t6.Quit");
            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    patient1.getLeftEye().getDetails();
                    if (patient1.getLeftEye().isOpened()) {
                        System.out.print("\n\t1. Close the eye: ");
                        if (input.nextInt() == 1)
                            patient1.getLeftEye().close();
                    else {
                            System.out.print("\n\t1. Open the eye: ");
                            if (input.nextInt() == 1)
                                patient1.getLeftEye().close();
                        }
                    }
                break;

                case 2:
                    patient1.getRightEye().getDetails();
                    if (patient1.getRightEye().isOpened()) {
                        System.out.print("\n\t1. Close the eye: ");
                        if (input.nextInt() == 1)
                            patient1.getRightEye().close();
                        else {
                            System.out.print("\n\t1. Open the eye: ");
                            if (input.nextInt() == 1)
                                patient1.getRightEye().close();
                        }
                    }
                    break;

                case 3:
                    patient1.getStomach().getDetails();
                    System.out.print("\t\n1.Digest: ");
                    if(input.nextInt() == 1)
                        patient1.getStomach().digest();
                    else
                        continue;
                    break;

                case 4:
                    patient1.getHeart().getDetails();
                    System.out.print("\t\n1. Change the heart rate: ");
                    if(input.nextInt() == 1) {
                        System.out.print("Enter the new heart rate: ");
                        int newHeartRate = input.nextInt();
                        patient1.getHeart().setHeartRate(newHeartRate);
                        System.out.println("The heart rate changed to: " + patient1.getHeart().getHeartRate());
                    }
                    else
                        continue;
                    break;

                case 5:
                    patient1.getSkin().getDetails();
                    break;

                default:
                    shouldFinish = true;
                    break;

            }
        }
    }
}