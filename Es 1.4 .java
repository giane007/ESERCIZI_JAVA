import static Tools.Utility.*;

import java.util.Scanner;
import java.util.Random;


public class Main {
   public static void main(String[] args) {
       Scanner tastiera = new Scanner(System.in);
       String[] opzioni = { "Menu", "1 Genera Random", "2 Visualizzazione", "3 Cancella", "4 Rimpiazza", "5 Ordina", "6 Crea Nuovo Vettore", "7 Fine" };
       boolean esci = true;
       final int MAXNUMERI = 100;
       int[] nEstratti2 = new int[MAXNUMERI]; // Array per memorizzare i numeri generati


       do {
           switch (Menu(opzioni, tastiera)) {
               case 1:
                   System.out.println("Generazione numeri casuali...");
                   generaNumeri2(nEstratti2);
                   break;
               case 2:
                   System.out.println("Visualizzazione numeri:");
                   visualizzaNumeri(nEstratti2);
                   break;
               case 3:
                   System.out.println("Inserisci il numero da cancellare:");
                   int numero = Integer.parseInt(tastiera.nextLine());
                   cancella(nEstratti2, numero);
                   break;
               case 4:
                   System.out.println("Inserisci il valore da rimpiazzare:");
                   int num = Integer.parseInt(tastiera.nextLine());
                   System.out.println("Inserisci il nuovo valore:");
                   int nuovoNum = Integer.parseInt(tastiera.nextLine());
                   rimpiazza(nEstratti2, num, nuovoNum);
                   break;
               case 5:
                   System.out.println("Ordinamento del vettore...");
                   ordinaVettore(nEstratti2);
                   break;
               case 6:
                   System.out.println("Creazione di un nuovo vettore doppio...");
                   int[] nuovoVettore = creaNuovoVettore(nEstratti2);
                   System.out.println("Visualizzazione del nuovo vettore:");
                   visualizzaNumeri(nuovoVettore);
                   break;
               case 7:
                   System.out.println("Fine del programma.");
                   esci = false;
                   break;
               default:
                   System.out.println("Opzione non valida. Riprova.");
           }
       } while (esci);
       tastiera.close();
   }


   // Funzione per generare numeri unici
   public static void generaNumeri2(int[] vettore) {
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


   // Funzione per cancellare un numero specifico e ricompattare il vettore
   public static void cancella(int[] vettore, int numero) {
       boolean trova = false;
       for (int i = 0; i < vettore.length; i++) {
           if (vettore[i] == numero) {
               trova = true;
               // Sposta gli elementi successivi a sinistra
               for (int j = i; j < vettore.length - 1; j++) {
                   vettore[j] = vettore[j + 1];
               }
               vettore[vettore.length - 1] = 0; // Mette 0 alla fine dopo la ricompattazione
               break; // Una volta trovato e rimosso, esce dal ciclo
           }
       }
       if (trova) {
           System.out.println("Numero " + numero + " cancellato e vettore ricompattato.");
       } else {
           System.out.println("Numero " + numero + " non trovato.");
       }
   }


   // Funzione per visualizzare i numeri in righe di 10
   public static void visualizzaNumeri(int[] vettore) {
       for (int i = 0; i < vettore.length; i++) {
           System.out.printf("%4d ", vettore[i]);
           if ((i + 1) % 10 == 0) {
               System.out.println(); // Nuova riga ogni 10 numeri
           }
       }
   }


   // Funzione per rimpiazzare un valore
   public static void rimpiazza(int[] vettore, int valoreDaRimpiazzare, int nuovoValore) {
       boolean trovato = false;
       for (int i = 0; i < vettore.length; i++) {
           if (vettore[i] == valoreDaRimpiazzare) {
               vettore[i] = nuovoValore;
               trovato = true;
               break;
           }
       }
       if (trovato) {
           System.out.println("Il numero " + valoreDaRimpiazzare + " è stato rimpiazzato con " + nuovoValore);
       } else {
           System.out.println("Numero " + valoreDaRimpiazzare + " non trovato.");
       }
   }


   // Funzione per ordinare l'array con il metodo di selezione
   public static void ordinaVettore(int[] vettore) {
       for (int i = 0; i < vettore.length - 1; i++) {
           int posizioneMinima = i;
           for (int j = i + 1; j < vettore.length; j++) {
               if (vettore[j] < vettore[posizioneMinima]) {
                   posizioneMinima = j;
               }
           }
           // Scambio
           int temp = vettore[posizioneMinima];
           vettore[posizioneMinima] = vettore[i];
           vettore[i] = temp;
       }
       System.out.println("Vettore ordinato.");
   }


   // Funzione per creare un nuovo vettore di dimensione doppia
   public static int[] creaNuovoVettore(int[] vettore) {
       int[] nuovoVettore = new int[vettore.length * 2];
       int elementiInseriti = 0;


       // Copia i numeri originali e poi inserisce i numeri al doppio
       for (int i = 0; i < vettore.length; i++) {
           nuovoVettore[elementiInseriti++] = vettore[i];
           nuovoVettore[elementiInseriti++] = vettore[i] * 2; // Valore doppio
       }
       System.out.println("Numero di elementi inseriti: " + elementiInseriti);
       return nuovoVettore;
   }


}

