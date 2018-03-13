package nio.handler;

import java.io.IOException;
import java.net.Socket;

/**
 * @author zzw
 * @see
 * @since 2018/3/12
 */
public class Handler implements Runnable {

    private Socket socket;
    private static final Integer MAX_INPUT = 1024;
    public Handler(Socket s){
        this.socket = s;
    }

    @Override
    public void run() {
        byte[] input = new byte[MAX_INPUT];
        try {
            socket.getInputStream().read(input);
            byte[] output = process(input);
            socket.getOutputStream().write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] process(byte[] input) {
        return input;
    }
}
