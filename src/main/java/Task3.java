import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liyang117
 * @Date: 2018/5/7 20:19
 * @Description:
 */
public class Task3 {

    public static String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static void gao(String[] args) {
        System.out.println(getTime());
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(getTime());
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.MINUTES);
    }
}
