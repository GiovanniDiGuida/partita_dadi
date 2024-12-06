import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("ciao benvenuto al casinò, come ti chiami?");

        Scanner input = new Scanner(System.in);
        String nome = input.nextLine();

        System.out.println("benvenuto al casinò " + nome + " sei pronto a spendere i tuoi soldi?");

        Random random = new Random();

        int turni = 3;

        int soldi = 100;

        boolean scelta = true;

        while (scelta) {

            int punti_pc = 0;
            int punti_utente = 0;
            if (soldi <= 0) {
                System.out.println("Hai finito i tuoi soldi aspetta la pensione");
                scelta = false;
            } else {
                System.out.println("quanto vuoi puntare? ");
                int puntata = input.nextInt();
                input.nextLine();

                if (soldi < puntata) {

                    System.out.println("non puoi puntare una somma maggiore dei tuoi soldi ");
                }

                else {
                    System.out.println("hai puntato " + puntata + " euro");

                    for (int i = 1; i <= turni; i++) {

                        int dado_pc1 = random.nextInt(6) + 1;
                        int dado_pc2 = random.nextInt(6) + 1;
                        int dado_utente1 = random.nextInt(6) + 1;
                        int dado_utente2 = random.nextInt(6) + 1;

                        int somma_pc = dado_pc1 + dado_pc2;
                        int somma_utente = dado_utente1 + dado_utente2;

                        System.out.println("il valore del dado 1 del pc é: " + dado_pc1);
                        System.out.println("il valore del dado 2 del pc é: " + dado_pc2);
                        System.out.println("il valore del dado 1 dell'utente è " + dado_utente1);
                        System.out.println("il valore del dado 2 dell'utente è: " + dado_utente2);

                        System.out.println("la somma del pc è: " + somma_pc);
                        System.out.println("la somma dell'utente è: " + somma_utente);

                        if (somma_pc > somma_utente) {

                            System.out.println("ha vinto il pc");
                            punti_pc++;
                        } else if (somma_utente > somma_pc) {

                            System.out.println("bravo, hai vinto " + nome);
                            punti_utente++;
                        } else {
                            System.out.println("pareggio");
                        }
                    }

                    System.out.println("il punteggio del pc è: " + punti_pc);
                    System.out.println("il punteggio di " + nome + " è: " + punti_utente);

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
                    boolean condizione2 = true;
                    while (condizione2) {
                        System.out.println("vuoi giocare ancora? (si/no)");
                        String ripetizione = input.nextLine();

                        if (ripetizione.equalsIgnoreCase("si")) {
                            System.out.println("giochiamo di nuovo ");
                            condizione2=false;
                        } else if (ripetizione.equalsIgnoreCase("no")) {
                            System.out.println("grazie per aver giocato");
                            scelta = false;
                            condizione2=false;
                        }else {
                            System.out.println("Errore di digitalizzazione");
                        }
                    }

                }

            }

        }

        input.close();
    }

}
