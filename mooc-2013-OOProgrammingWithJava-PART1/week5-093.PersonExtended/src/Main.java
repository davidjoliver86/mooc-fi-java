public class Main {
  public static void main(String[] args) {
    // write test code here
    // Person pekka = new Person("Pekka", 15, 2, 1993);
    
    Person h1 = new Person("Jarmo", 15, 9, 1954);
    Person h2 = new Person("Petteri", 4, 4, 1978);
    System.out.println(h1.olderThan(h2));
  }
}
