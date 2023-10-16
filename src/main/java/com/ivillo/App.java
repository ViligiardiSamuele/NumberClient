package com.ivillo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String risposta = new String();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Indovina numero da 0 a 100: \"-1\" per uscire");
            
            do {
                System.out.print("Numero: ");
                out.writeBytes(scanner.nextLine() + '\n');
                risposta = in.readLine();
                switch(risposta)
                {
                    case "1":
                        System.out.println("Il numero è più piccolo");
                    break;
                    case "-1":
                        System.out.println("Il numero è più grande");
                    break;
                    case "0":
                        System.out.println("HAI INDOVINATO!!! con " + in.readLine() + " tentativi");
                    break;
                    case "-2":
                        System.out.println("Disconnesso...");
                    break;
                }
            } while (Integer.parseInt(risposta) != -2 );
            scanner.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Qualcosa è andato storto, chiusura del client...");
            System.exit(1);
        }
    }
}
