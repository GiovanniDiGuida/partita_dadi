import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("ciao benvenuto al casinò, come ti chiami?");

        Scanner input = new Scanner(System.in); // mi creo l'istanza per fare l'input da tastiera
        String nome = input.nextLine(); // Chiedo il nome del giocatore

        System.out.println("benvenuto al casinò " + nome + " sei pronto a spendere i tuoi soldi?");

        Random random = new Random(); // mi creo l'istanza per generare i numeri random
        // mi creo le variabili globali
        System.out.println("Scrivi i turni che vuoi fare: ");
        int turni = input.nextInt();
        input.nextLine();
        System.out.println("Quanti soldi decidi di buttare?: ");
        int soldi = input.nextInt();
        input.nextLine();

        boolean scelta = true;

        while (scelta) {
            // variabili locali che devono resettarsi ad ogni while
            int punti_pc = 0;
            int punti_utente = 0;
            // faccio un if per controllare se ci sono soldi
            if (soldi <= 0) {
                System.out.println("Hai finito i tuoi soldi aspetta la pensione");
                scelta = false;
            } else {
                System.out.println("quanto vuoi puntare? ");
                int puntata = input.nextInt(); // input per chiedere all utente quanto vuole puntare
                input.nextLine();
                // controllo se la puntata è uguale o minore dei soldi
                if (soldi < puntata) {

                    System.out.println("non puoi puntare una somma maggiore dei tuoi soldi ");
                }

                else {
                    System.out.println("hai puntato " + puntata + " euro");

                    for (int i = 1; i <= turni; i++) { // for che mi serve per ripetere i 3 turni
                        // creazioni delle variabili che contengono i numeri random per giocare
                        int dado_pc1 = random.nextInt(6) + 1;
                        int dado_pc2 = random.nextInt(6) + 1;
                        int dado_utente1 = random.nextInt(6) + 1;
                        int dado_utente2 = random.nextInt(6) + 1;

                        int somma_pc = dado_pc1 + dado_pc2;
                        int somma_utente = dado_utente1 + dado_utente2;
                        // stampa generale dei risultati
                        System.out.println("il valore del dado 1 del pc é: " + dado_pc1);
                        System.out.println("il valore del dado 2 del pc é: " + dado_pc2);
                        System.out.println("il valore del dado 1 dell'utente è " + dado_utente1);
                        System.out.println("il valore del dado 2 dell'utente è: " + dado_utente2);

                        System.out.println("la somma del pc è: " + somma_pc);
                        System.out.println("la somma dell'utente è: " + somma_utente);
                        // controllo con un if per dimostrare chi è il vincitore/perdente/pareggio
                        if (somma_pc > somma_utente) {

                            System.out.println("ha vinto il pc");
                            punti_pc++;// variabile incrementale che tiene conto del numero di vittorie per giocare/pc
                        } else if (somma_utente > somma_pc) {

                            System.out.println("bravo, hai vinto " + nome);
                            punti_utente++;////variabile incrementale che tiene conto del numero di vittorie per giocare/pc
                        } else {
                            System.out.println("pareggio");
                        }
                    }

                    System.out.println("il punteggio del pc è: " + punti_pc);
                    System.out.println("il punteggio di " + nome + " è: " + punti_utente);
                    // gestione con if per incrementare o diminuire i soldi in base alla vittoria o
                    // sconfitta
                    if (punti_pc > punti_utente) {

                        soldi = soldi - puntata;

                        System.out.println("alla fine dei tre turni ha vinto il pc");

                    } else if (punti_utente > punti_pc) {

                        soldi = soldi + puntata;

                        System.out.println("alla fine dei tre turni ha vinto " + nome);
                    } else {
                        System.out.println("alla fine dei tre turni la partita si è conclusa in pareggio");
                    }
                    System.out.println("i tuoi soldi sono: " + soldi);
                    boolean condizione3 = true;
                    if (soldi > 0) {
                        while (condizione3) {
                            System.out.println(("Vuoi ritirare dei soldi: (si/no)"));
                            String scelta_ritiro = input.nextLine();
                            if (scelta_ritiro.equalsIgnoreCase("si")) {
                                System.out.println("Quanto vuoi ritirare?: ");
                                int scelta_soldi = input.nextInt();
                                input.nextLine();
                                soldi = soldi - scelta_soldi;
                                System.out.println("i tuoi soldi sono: " + soldi);
                                condizione3 = false;
                            } else if (scelta_ritiro.equalsIgnoreCase("no")) {
                                System.out.println("ok hai deciso di non ritirare.");
                                condizione3 = false;
                            } else {
                                System.out.println("Errore di digitalizzazione");
                            }

                        }
                    }else {
                        System.out.println("Non puoi ritirare nulla hai perso tutti i soldi");
                    }

                    // qui creazione di variabile locale booleana e un piccolo while che gestice se
                    // ci sono errori di digitalizzazione
                    boolean condizione2 = true;
                    while (condizione2) {
                        System.out.println("vuoi giocare ancora? (si/no)");
                        String ripetizione = input.nextLine();

                        if (ripetizione.equalsIgnoreCase("si")) {
                            System.out.println("giochiamo di nuovo ");
                            condizione2 = false;
                        } else if (ripetizione.equalsIgnoreCase("no")) {
                            System.out.println("grazie per aver giocato");
                            scelta = false;
                            condizione2 = false;
                        } else {
                            System.out.println("Errore di digitalizzazione");
                        }
                    }

                }

            }

        }

        input.close();
    }

}
