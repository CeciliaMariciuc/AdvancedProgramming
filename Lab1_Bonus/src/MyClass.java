public class MyClass {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        int nr1 = Integer.parseInt("10101", 2);
        n = n + nr1;
        int nr2 = Integer.parseInt("FF", 16);
        n = n + nr2;
        n = n * 6;
        int sumcif = 0;
       // System.out.printf("%d %d\n",n, sum);
        while (n > 0 || sumcif > 9)
        {
            if (n == 0) {
                n = sumcif;
                sumcif = 0;
            }
            sumcif = sumcif + n % 10;
            n = n/10;
        }
        System.out.printf("Willy-nilly, this semester I will learn %s\n", languages[sumcif]);
    }
}
