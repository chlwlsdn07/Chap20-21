// 간단한 멀티스레드 예제
public class chap21_01 {
    public static void main(String[] args) {
        Thread myThread1 = new Thread()
 {
     @Override
     public void run() {
         for(int i=1; i<=50; i++) {
             System.out.println(i);
         }
     }
 };
 Thread myThread2 = new Thread(){
     @Override
     public void run() {
         for(int i=51; i<=100; i++) {
             System.out.println(i);
         }
     }
 };
 myThread1.start();
 myThread2.start();

    }
}
