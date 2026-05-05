import java.util.List;

public class LogAnalyzer implements Runnable {
    private List<String> chunk;
    private int errorCount = 0;
    private int apiUsersCount = 0;

    public LogAnalyzer(List<String> chunk) {
        this.chunk = chunk;
    }

    @Override
    public void run() {
        for (String str: chunk){
            if (str.contains("ERROR")){
                errorCount++;
            }
            if (str.contains("/api/users")){
                apiUsersCount++;
            }
        }
    }

    public int getApiUsersCount() {
        return apiUsersCount;
    }

    public int getErrorCount() {
        return errorCount;
    }
}
