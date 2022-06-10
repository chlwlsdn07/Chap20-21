// 동기화 블록 예제
public class chap21_02 {
    private int data=0;
    private Object obj = new Object();

    public void increment(){
        synchronized(obj) {
            for(int i =0; i<100000; i++){
                data = data+1;
            }
        }
    }
    public int getData(){
        return data;
    }
    
}
