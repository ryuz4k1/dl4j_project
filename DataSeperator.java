import java.io.*;
import java.lang.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



    public class DataSeperator{

        public static void main(String []arg) throws IOException{


            try{

                Scanner scan = new Scanner(new File("ALLARCHEAGEPOS.txt"));

                String line = null;
                String x = ".txt";

                String z;
                int y = 0;
                String filename;


                while(scan.hasNextLine()) {

                    z = String.valueOf(y);

                    filename = z + x;
                    y++;

                    line = scan.nextLine();
                    writef(line,filename);

                }

            }catch(FileNotFoundException | ArrayIndexOutOfBoundsException e){

                System.out.println(e);

            }
        }



        public static void writef(String a, String filename){

            try{

                FileWriter fileWriter =
                    new FileWriter(filename);

                BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

                bufferedWriter.write(a);
                bufferedWriter.close();

            }catch(Exception e){
                System.out.println(e);
            }
        }



    }

