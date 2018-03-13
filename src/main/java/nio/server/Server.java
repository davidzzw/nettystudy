package nio.server;

import nio.handler.Handler;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author zzw
 * @see
 * @since 2018/3/12
 */
public class Server {
    public void run(){
        try {
            ServerSocket ss = new ServerSocket(8080);
            while (ss.accept() != null){
                new Thread(new Handler(ss.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
