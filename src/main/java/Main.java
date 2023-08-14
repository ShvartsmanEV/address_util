import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату в формате yyyy-MM-dd");
        //2010-01-01
        String date =sc.nextLine();
        //1422396,1450759,1449192,1451562
        System.out.println("Введите номера id");
        String ids = sc.nextLine().trim();
        sc.close();
        Parser jacksonParser = new Parser();
        jacksonParser.getObjectsInfo(date,ids);

    }
}
