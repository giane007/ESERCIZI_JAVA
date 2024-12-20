import static Utility.Tools.*;
import java.util.Scanner;
import java.util.Random;


public class Main {
   public static void main(String[] args) {
       Scanner tastiera = new Scanner(System.in);
       String[] opzioni = {"Menu", "Genera Random", "Visualizzazione","Cerca posizione" ,"Fine"};
       boolean esci = true;
       final int MAXNUMERI = 100;
       int[] nEstratti2 = new int[MAXNUMERI]; // Array per memorizzare i numeri generati
       int valore;


       do {
           switch (Menu(opzioni, tastiera)) {
               case 1:
                   System.out.println("Generazione");
                   generaNumeri(nEstratti2);
                   break;
               case 2:
                   System.out.println("Visualizzazione");
                   //for (int i = 0; i < nEstratti2.length; i++)
                       //System.out.println(nEstratti2[i]);
                       System.out.println(visualizza(nEstratti2));
                   break;
               case 3:
                   System.out.println("Che valore vuoi cercare?");
                   valore = (Integer.parseInt(tastiera.nextLine()));
                   System.out.println("Cerca numero e posizione");
                   if (esiste(nEstratti2, tastiera,valore)){
                       System.out.println("E' presente nel vettore");
                   } else {
                       System.out.println("Non è presente");
                   }
                   System.out.println(cerca(nEstratti2,tastiera));
               case 4:
                   System.out.println("Fine");
                   esci = false;
                   break;
           }
       } while (esci);
   }



   // Funzione per generare numeri unici
   public static void generaNumeri(int[] vettore) {
       Random numeroRandom = new Random();
       int cont = 0;




       while (cont < vettore.length) {
           int numeroGenerato = numeroRandom.nextInt(vettore.length) + 1;




           // Controlla se il numero generato è già stato inserito nell'array
           if (!esisteNelVettore(vettore, numeroGenerato, cont)) {
               vettore[cont] = numeroGenerato;
               cont++;
           }
       }
   }


   // Funzione/metodo per verificare se un numero esiste già nel vettore
   public static boolean esisteNelVettore(int[] vettore, int numero, int limite) {
       for (int i = 0; i < limite; i++) {
           if (vettore[i] == numero) {
               return true;
           }
       }
       return false;
   }
   public static int visualizza(int[] vettore){
       int conta=0;
       for (int i : vettore){
           System.out.printf("%4d", i);
           conta++;
           if(conta==10){
               System.out.println();
               conta=0;
           }
       }
       return 0;
   }
   public static boolean esiste(int[] vettore, Scanner tastiera,int valore){
      
      
      


       for(int i : vettore){
           if(valore == vettore[i]){
               return true;
           }
       }
       return false;
   }
   public static int cerca(int[] vettore, Scanner tastiera){
       int valore;
       System.out.println("di che valore vuoi la posizione?");
       valore = (Integer.parseInt(tastiera.nextLine()));


       for(int i : vettore){
           if(valore== vettore[i]){
               System.out.println("posizione: " + (i+1));
           }else{
               System.out.println("valore non trovato");
           }
       }
       return 0;
   }




}

