public class Interpret {
    public static void main(String[] args){
        Thread thread = new Thread(()->{
            try{
                Thread.sleep(50000);
            }catch (InterruptedException e){
                System.out.println("Exception");
            }
        });
        thread.start();
        thread.interrupt();
    }
}
