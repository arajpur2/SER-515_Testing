/*
* @author Alok Rajpurohit, arajpur2@asu.edu
* @version 1.0
* @since 10-27-2022
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@SuppressWarnings("all")
public class Urinals {

    public String[] readFile(){
        String files = "src\\main\\data\\urinal.dat";

        Path filePath = Paths.get(files);
        String fileContent = null;

        try {
            fileContent = Files.readString(filePath);
        } catch (FileNotFoundException e){
            String[] str = {"File does not exist"};
            return str;
        } catch (IOException e) {
            System.out.println("WARNING: DATABASE READ ERROR");
        }

        String[] lines = fileContent.split("\\r?\\n");

        return lines;
    }

    public void writeFile(int urinalCount, int counter){
        try{
            File f1;
            if(counter==-1){
                f1 = new File("src\\main\\data\\rule.txt");
            } else {
                f1 = new File("src\\main\\data\\rule" + String.valueOf(counter+1) + ".txt");
            }

            FileWriter fileWriter = new FileWriter(f1,true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(String.valueOf(urinalCount) + "\n");
            bw.close();
        } catch (Exception e){
            System.out.println("DATABASE WRITE ERROR");
        }
    }

    public String[] getInputString(int choice){
        String[] inputString = new String[1000];

        switch (choice){
            case 1:
                try {
                    System.out.println("PLEASE ENTER THE URINAL REPRESENTATION STRING");
                    Scanner sc2 = new Scanner(System.in);
                    inputString[0] = sc2.nextLine();
                } catch (Exception e){
                    System.out.println("Wrong type of input!");
                }
                break;
            case 2:
                inputString = this.readFile();
                break;
            default:
                System.out.println("Wrong choice!");
        }

        return inputString;
    }

    public int countUrinals(String inputString){
        int urinalCounter = 0;
        if(inputString.length() > 20){
            return -1;
        } else {

            for(int i = 0; i<inputString.length(); i++) {
                if (inputString.charAt(i) != '1' && inputString.charAt(i) != '0') {
                    return -1;
                }
            }

            for(int i = 0; i<inputString.length(); i++){
                if(inputString.length() == 1){
                    if(inputString.equals("1"))
                        return 0;
                    else
                        return 1;
                }

                if(i==0){
                    if(inputString.charAt(i) == '1' && inputString.charAt(i+1) == '1')
                        return -1;
                    if(inputString.charAt(i) == '0' && inputString.charAt(i+1) != '1'){
                        urinalCounter++;
                        i++;
                    }
                } else if (i==(inputString.length()-1)){
                    if(inputString.charAt(i) == '0' && inputString.charAt(i-1) != '1'){
                        urinalCounter++;
                        i++;
                    }
                } else {
                    if(inputString.charAt(i) == '1' && inputString.charAt(i+1) == '1')
                        return -1;
                    if(inputString.charAt(i) == '0' && inputString.charAt(i+1) != '1' && inputString.charAt(i-1) != '1') {
                        urinalCounter++;
                        i++;
                    }
                }

            }
            return urinalCounter;
        }
    }

    public static void main(String[] args){
        int choice = 0;
        try{
            System.out.println("1. ENTER INPUT FROM KEYBOARD");
            System.out.println("2. GET INPUT FROM FILE");
            System.out.println("ENTER YOUR CHOICE.");
            Scanner sc1 = new Scanner(System.in);
            choice = sc1.nextInt();
        } catch (Exception e){
            System.out.println("Wrong Input!");
        }

        Urinals urinals = new Urinals();
        if(choice == 1){
            String[] inputString = urinals.getInputString(choice);
            int urinalCount = urinals.countUrinals(inputString[0]);
            System.out.println(urinalCount);
        }
        if(choice == 2){
            final File folder = new File("src\\main\\data");
            int counter = -1;
            for (final File fileEntry : folder.listFiles()) {
                String fileName = fileEntry.getName();
                if (fileName.charAt(5) == 'l')
                    continue;
                if (fileName.charAt(4) != '.'){
                    counter = Integer.parseInt(String.valueOf(fileName.charAt(4)));
                } else {
                    counter = 0;
                }
            }
            String[] inputString = urinals.getInputString(choice);
            for(String i: inputString){
                if(i.equals("-1"))
                    break;
                int urinalCount = urinals.countUrinals(i);
                urinals.writeFile(urinalCount, counter);
            }
            System.out.println("Output successfully written to file!");
        }
    }
}
