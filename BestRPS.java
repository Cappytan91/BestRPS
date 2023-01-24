/**
 * @(#)RPSGoing.java
 *
 *
 * @author
 * @version 1.00 2021/11/10
 */

import java.util.Scanner;
import javax.swing.*;
import java.util.Random;
import java.io.*;
import java.nio.file.Files;

public class BestRPS {

    public static void main(String[] args) {
        int Wins = 0, WinB = 0, Ties = 0, Rock = 0, Paper = 0, Scissors = 0;

        CheckMakeDir();

        GetStoredVars(Wins, WinB, Ties, Rock, Paper, Scissors);

    }

    static void GetStoredVars(int Wins, int WinB, int Ties, int Rock, int Paper, int Scissors){
        Scanner inputS = null;
        Scanner inputP = null;
        Scanner inputR = null;
        Scanner inputWs = null;
        Scanner inputWb = null;
        Scanner inputT = null;
        try {
            inputS = new Scanner(new File("RockPaperScissorsDir/Scissors.fart"));
            Scissors = inputS.nextInt();
            System.out.println(Scissors);

        } catch (Exception ex) {
            System.out.println("File Not Created Yet.");

        } try {
            inputP = new Scanner(new File("RockPaperScissorsDir/Paper.fart"));
            Paper = inputP.nextInt();
            System.out.println(Paper);

        } catch (Exception ex) {
            System.out.println("File Not Created Yet.");
        } try {
            inputR = new Scanner(new File("RockPaperScissorsDir/Rock.fart"));
            Rock = inputR.nextInt();
            System.out.println(Rock);

        } catch (Exception ex) {
            System.out.println("File Not Created Yet.");
        } try {
            inputWs = new Scanner(new File("RockPaperScissorsDir/Wins.fart"));
            Wins = inputWs.nextInt();
            System.out.println(Wins);

        } catch (Exception ex) {
            System.out.println("File Not Created Yet.");
        } try {
            inputWb = new Scanner(new File("RockPaperScissorsDir/WinB.fart"));
            WinB = inputWb.nextInt();
            System.out.println(WinB);

        } catch (Exception ex) {
            System.out.println("File Not Created Yet.");
        } try {
            inputT = new Scanner(new File("RockPaperScissorsDir/Wins.fart"));
            Ties = inputT.nextInt();
            System.out.println(Ties);

        } catch (Exception ex) {
            System.out.println("File Not Created Yet.");
        }

        sus(Wins, WinB, Ties, Rock, Paper, Scissors);
    }


    static void CheckMakeDir(){
        if(!(new File("RockPaperScissorsDir").exists())){
            (new File("RockPaperScissorsDir")).mkdir();
        }
    }

    static void sus(int Wins, int WinB, int Ties, int Rock, int Paper, int Scissors){

        boolean Win;

        String[] options = new String[] {"Rock", "Paper", "Scissors", "Stats","Close"};
        String[] stats = new String[] {"Back", "More"};
        String[] moreStats = new String[] {"Back To Game"};

        int response = -1;

        while(response != 4){

            response = JOptionPane.showOptionDialog(null, "Input Rock, Paper, or Scissors", "Rock Paper Scissors", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
            Random r = new Random();
            int bot = r.nextInt(3);

            if(response == 0){
                Rock++;
                try {

                    Writer w = new FileWriter("RockPaperScissorsDir/Rock.fart");
                    w.write(Rock + "");
                    w.close();
                    System.out.println("Done");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(response == 1){
                Paper++;
                try {
                    Writer w = new FileWriter("RockPaperScissorsDir/Paper.fart");
                    w.write(Paper + "");
                    w.close();
                    System.out.println("Done");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(response == 2){
                Scissors++;
                try {
                    Writer w = new FileWriter("RockPaperScissorsDir/Scissors.fart");
                    w.write(Scissors + "");
                    w.close();
                    System.out.println("Done");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(response == 3){
                int statsPage = JOptionPane.showOptionDialog(null, "Results:\nYour wins: " + Wins + "\nBot wins: " + WinB + "\nTies: " + Ties, "Rock Paper Scissors Stats", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, stats, stats[0]);

                if(statsPage == 0 || statsPage == JOptionPane.CLOSED_OPTION){
                    sus(Wins, WinB, Ties, Rock, Paper, Scissors);
                    break;
                }else if(statsPage == 1){
                    int morePage = JOptionPane.showOptionDialog(null, "More Stats:\nRock: " + Rock + "\nPaper: " + Paper + "\nScissors: " + Scissors, "Rock Paper Scissors More Stats", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, moreStats, moreStats[0]);
                    if(morePage == 0 || morePage == JOptionPane.CLOSED_OPTION){
                        sus(Wins, WinB, Ties, Rock, Paper, Scissors);
                        break;
                    }
                }
            }

            if(response == 4 || response == JOptionPane.CLOSED_OPTION){
                JOptionPane.showMessageDialog(null, "Results:\nYour wins: " + Wins + "\nBot wins: " + WinB + "\nTies: " + Ties, "Rock Paper Scissors Stats", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            if(bot == response){
                JOptionPane.showMessageDialog(null, "You and the Bot tied", "Rock Paper Scissors Tie", JOptionPane.INFORMATION_MESSAGE);
                Ties++;

                try {
                    Writer w = new FileWriter("RockPaperScissorsDir/Ties.fart");
                    w.write(Ties + "");
                    w.close();
                    System.out.println("Done");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(bot == 0 && response == 1){
                JOptionPane.showMessageDialog(null, "You Won\nBot Picked: Rock\nYou Picked: Paper", "Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
                Wins++;
                Win = true;
            }else if(bot == 1 && response == 2){
                JOptionPane.showMessageDialog(null, "You Won\nBot Picked: Paper\nYou Picked: Scissors", "Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
                Wins++;
                Win = true;
            }else if(bot == 2 && response == 0){
                JOptionPane.showMessageDialog(null, "You Won\nBot Picked: Scissors\nYou Picked: Rock", "Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
                Wins++;
                Win = true;
            }else{
                WinB++;
                Win = false;
                String botA = "Error", resA = "Error";
                if(bot == 0){
                    botA = "Rock";
                }else if(bot == 1){
                    botA = "Paper";
                }else if(bot == 2){
                    botA = "Scissors";
                }

                if(response == 0){
                    resA = "Rock";
                }else if(response == 1){
                    resA = "Paper";
                }else if(response == 2){
                    resA = "Scissors";
                }

                JOptionPane.showMessageDialog(null, "Bot Won\nBot Picked: " + botA + "\nYou Picked: " + resA, "Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);

                try {
                    Writer w = new FileWriter("RockPaperScissorsDir/WinB.fart");
                    w.write(WinB + "");
                    w.close();
                    System.out.println("Done");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(Win = true){
                try {
                    Writer w = new FileWriter("RockPaperScissorsDir/Wins.fart");
                    w.write(Wins + "");
                    w.close();
                    System.out.println("Done");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
