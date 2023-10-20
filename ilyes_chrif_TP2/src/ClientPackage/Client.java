package ClientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

public static void main(String [] args)
{

    try{

      // Créer un socket et se connecter à un serveur en cours d'exécution sur localhost au port 500
      Socket sk = new Socket("localhost",500);

      // flux d'entrée pour recevoir des données du serveur
      InputStream is = sk.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);

      // les options du menu pour l'utilisateur
      System.out.println("1)addition");
      System.out.println("2)soustaction");
      System.out.println("3)multiplication");
      System.out.println("4)division\n");

      // Scanner pour lire la saisie de l'utilisateur
      Scanner sc = new Scanner(System.in);

      System.out.println("donner entier 1:");
      int ent1=sc.nextInt();

      sc.nextLine(); // Consommer le caractère de nouvelle ligne


      // Demander à l'utilisateur d'entrer un opérateur mathématique
      String op;
      do{
          System.out.println("donner un operateur :");
          op = sc.nextLine();
      }
      while(!op.equals("+")&&!op.equals("-")&&!op.equals("/")&&!op.equals("*"));

      System.out.println("donner entier 2:");
      int ent2=sc.nextInt();

      // flux de sortie pour envoyer des données au serveur
      OutputStream os = sk.getOutputStream();
      PrintWriter pw = new PrintWriter(os,true);

      pw.println(ent1); // Envoyer le premier entier
      pw.println(op);   // Envoyer l'opérateur
      pw.println(ent2); // Envoyer le second entier

      // Recevoir le résultat du serveur et l'afficher
      int res =Integer.parseInt(br.readLine());
      System.out.println("\nResultat : "+res);

      // Fermer la connexion du socket
      sk.close();
    }
    catch(Exception e)
    {
       System.out.println("erreur "+e.getMessage());
    }
}

}
