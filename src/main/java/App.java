import io.reactivex.Observable;

public class App {

  public static void main(String[] args) {
    Observable.range(1, 5).subscribe(
        number -> System.out.println("Your current balance is: " + number),
        error -> System.out.println("Error: " + error),
        () -> System.out.println("Done")
    );
  }
}
