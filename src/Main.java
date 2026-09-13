import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        ===== STUDENT GRADE MANAGER =====

            1. Afiseaza toti studentii
            2. Afiseaza notele
            3. Cauta un student
            4. Calculeaza media clasei
            5. Afiseaza cea mai mare nota
            6. Afiseaza cea mai mica nota
            7. Afiseaza studentii promovati
            8. Exit
            9. Statistici

            1 Stea: Introducere de la tastatura a studentilor si a notelor

            2 Stele: 9.Statistici
            Numar studenti: 5
            Promovati: 4
            Picati: 1
            Media: 7.8
            Nota maxima: 10
            Nota minima: 4
         */

        boolean terminat=true;
        System.out.println("Introdu numarul studentilor pe care i vrei");
        int numar = scanner.nextInt();
        scanner.nextLine();
        String[] studenti = new String[numar];
        int[] note = new int[numar];

        for (int i = 0; i < numar; i++) {
            System.out.println("Scrie numele studentului");
            studenti[i] = scanner.nextLine();
        }

        for (int i = 0; i < numar; i++) {
            System.out.println("Scrie nota studentului " + studenti[i]);
            note[i] = scanner.nextInt();
        }

        while(terminat) {
            System.out.println("===== STUDENT GRADE MANAGER =====\n" +
                    "\n" +
                    "            1. Afiseaza toti studentii\n" +
                    "            2. Afiseaza notele\n" +
                    "            3. Cauta un student\n" +
                    "            4. Calculeaza media clasei\n" +
                    "            5. Afiseaza cea mai mare nota\n" +
                    "            6. Afiseaza cea mai mica nota\n" +
                    "            7. Afiseaza studentii promovati\n" +
                    "            8. Exit\n" +
                    "            9. Statistici"+
                    "\n" +
                    "            Alege o optiune:");
            int alegere = scanner.nextInt();

            switch (alegere) {
                case 1 -> afisareNume(numar, studenti);
                case 2 -> afisareNote(numar, note);
                case 3 -> cautareStudent(numar, studenti, note);
                case 4 -> System.out.println(mediaClasei(numar, note));
                case 5 -> System.out.println(maxim(numar, note));
                case 6 -> System.out.println(minim(numar, note));
                case 7 -> promovati(numar, note, studenti);
                case 8 -> {
                    System.out.println("Multumim ca ati folosit service ul nostru");
                    terminat=false;
                }
                case 9 -> statistici(numar, note, studenti);
                default -> System.out.println("varianta ta este invalida");
            }
        }
    }

    static void afisareNume(int numar, String[] studenti) {
        for (int i = 0; i < numar; i++) {
            System.out.println(studenti[i]);
        }
    }

    static void afisareNote(int numar, int[] note) {
        for (int i = 0; i < numar; i++) {
            System.out.println(note[i]);
        }
    }

    static void cautareStudent(int numar, String[] studenti, int[] note) {
        int gasit=-1;
        System.out.println("ce elev cauti? ");
        scanner.nextLine();
        String target = scanner.nextLine();
        for (int i = 0; i < numar; i++) {
            if (studenti[i].equals(target)) {
                gasit=i;
            }
        }

        if (gasit != -1) {
            System.out.printf("%s are nota %d \n", studenti[gasit], note[gasit]);
        } else {
            System.out.println("studentul nu a fost gasit");
        }
    }

    static double mediaClasei(int numar, int[] note) {
        double total = 0;
        double medie = 0;
        for (int i = 0; i < numar; i++) {
            total += note[i];
        }
        medie = total / note.length;
        return medie;
    }

    static int maxim(int numar, int[] note) {
        int max = 0;
        for (int i = 0; i < numar; i++) {
            if (note[i] > max) {
                max = note[i];
            }
        }
        return max;
    }

    static int minim(int numar, int[] note) {
        int min = 100;
        for (int i = 0; i < numar; i++) {
            if (note[i] < min) {
                min = note[i];
            }
        }
        return min;
    }

    static void promovati(int numar, int[] note, String[] studenti) {
        for (int i = 0; i < numar; i++) {
            if (note[i] >= 5) {
                System.out.printf("Studenti promovati \n %s - %d\n", studenti[i], note[i]);
            }
        }
    }

    static void statistici(int numar, int[] note, String[] studenti)
    {
        int numarStudenti=studenti.length;
        int promovati=0;
        int picati=0;
        double medie=0;
        int max=0;
        int min=11;
        for(int i=0;i<numar;i++)
        {
            if(note[i]>=5)
            {
                promovati++;
            }
            if(note[i]<5)
            {
                picati++;
            }
        }
        System.out.printf("Numar studenti: %d \n Promovati: %d\n Picati: %d\n Media: %.2f\n Nota Maxima: %d \n Nota minima %d",numarStudenti,promovati,picati,mediaClasei(numar,note),maxim(numar,note),minim(numar,note));
    }
}