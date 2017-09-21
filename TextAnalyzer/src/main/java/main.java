import java.io.*;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        Brackets brak = new Brackets();
        CountingWords cw = new CountingWords();
        File f= new File("d:\\test1.txt");
        String text="";
        String str;
        try {
            //cчитывает русский,английских текст
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "Cp1251"));
            while ((str = br.readLine()) != null) {
                text+=str+"\n";
            }
            System.out.println("YO!You are welcomed by the program \"Text Analyzer\"");
            while (true) {
                System.out.println("-------------------------------------------");
                System.out.println("Menu:");
                System.out.println("1 - Top 10 most common words");
                System.out.println("2 - Checking the correctness of the brackets");
                System.out.println("3 - Stop");
                System.out.println("Enter 1,2 or 3");
                System.out.println("-------------------------------------------");
                String answer = in.next();
                int answ = Integer.parseInt(answer);
                switch (answ) {
                    case 1:
                        //замена знаков препинания на пробел
                        String s = text.replaceAll(("[^a-zA-Zа-яА-Я]"), " ");
                        //преобразование строки в массив слов
                        String[] a = s.split("\\s");
                        cw.ParticleRemove(a);
                        cw.Sort(a);
                        cw.CountingMax(a);
                        break;
                    case 2:
                        brak.Test(text);
                        break;
                    case 3: return;
                    default:System.out.println("Unknown command");
                        break;
                }
            }

        } catch (IOException e0) {
            System.out.println("Fail not found!");
        }
    }
}
