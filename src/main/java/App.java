import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import io.reactivex.Observable;

public class App {

  public static void main(String[] args) throws InterruptedException {
    Queue<Integer> myQueue = new PriorityQueue<>();

    myQueue.add(1);

    Observable<Integer> integerObservable = Observable.fromIterable(myQueue);

    integerObservable.subscribe(
        number -> System.out.println("You entered this number: " + number),
        error -> System.out.println("There was an error!")
    );

    Scanner scanner = new Scanner(System.in);

    while (true) {
      Thread.sleep(1 * 1000);
      System.out.println("Enter a number or numbers separated by spaces: ");
      String input = scanner.nextLine();
      String[] integerArray = input.split(" ");
      for (String s : integerArray) {
        try {
          Integer i = Integer.valueOf(s);
          myQueue.add(i);

        } catch (NumberFormatException e) {
          integerObservable.onTerminateDetach();
        }
      }
    }
  }
}
