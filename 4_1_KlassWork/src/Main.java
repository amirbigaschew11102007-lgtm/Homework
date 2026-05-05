public class Main{
    public static void main(String[] args) {
//        MyTread myTread = new MyTread();
//        или

        MyRunnableThread runnableThread = new MyRunnableThread();

        Thread tread = new Thread(runnableThread);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

//      if (Верим вике && жалоб >5){
//        thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                блочим юзера
//            }
//        })
//        else if (Верим вике && жалоб <5){
//        thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                добавляем жалобу
//            }
//        })
//        else{
//        thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                блочим вику
//            }
//        });
//    }

        tread.start();

        System.out.println("запущен");
        for (int i=1;i<100;i++){
            System.out.println("инфы: "+ i);
        }
        System.out.println("Конец");

        //1) заблочить аккаунт
        //2) просто занести в бд
        //3) блочить того, кто пожаловался


    }
}