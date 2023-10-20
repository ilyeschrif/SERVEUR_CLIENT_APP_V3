package ServerPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String [] args){

      try{

          // Créer un socket serveur qui écoute sur le port 500
          ServerSocket ssk = new ServerSocket(500);

          // Attendre qu'un client se connecte et accepter la connexion
          Socket sk = ssk.accept();

          // flux de sortie pour envoyer des données au client
          OutputStream os=sk.getOutputStream();

          // flux d'entrée pour lire les données du client
          InputStream is = sk.getInputStream();
          InputStreamReader isr = new InputStreamReader(is);
          BufferedReader br = new BufferedReader(isr);

          // Lire le premier entier envoyé par le client
          int  ent1 =Integer.parseInt(br.readLine());

          // Lire l'opérateur envoyé par le client
          String  op = br.readLine();

          // Lire le deuxième entier envoyé par le client
          int  ent2 =Integer.parseInt(br.readLine());

          // switch pour effectuer l'opération appropriée en fonction de l'opérateur
          int res=0;
              switch (op)
              {
                  case "+":
                      res=ent1+ent2;break;
                  case "-":
                      res=ent1-ent2;break;
                  case "*":
                      res=ent1*ent2;break;
                  case "/":
                      res=ent1/ent2;break;

              }

              // Créer un objet PrintWriter pour écrire des données dans le flux de sortie 'os' vers le client
              PrintWriter pw =new PrintWriter(os,true);

              // Envoyer le résultat 'res' au client en utilisant le PrintWriter
              pw.println(res);

              System.out.println("resultat envoie!");

              // Fermer la connexion du socket
              sk.close();

      }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
      }



    }


}
