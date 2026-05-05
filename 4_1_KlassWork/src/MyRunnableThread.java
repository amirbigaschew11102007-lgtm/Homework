public class MyRunnableThread implements Runnable{
    @Override
    public void run(){
        System.out.println("Поток запущен");

        for (int i=1;i<100;i++){
            System.out.println("Поток инфы: "+ i);
        }
        System.out.println("Конец потока");
    }
}
