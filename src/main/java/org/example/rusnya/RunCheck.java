package org.example.rusnya;
import org.example.ImportAnek;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class RunCheck {
    public static void main(String[] args) throws AWTException {
        System.setProperty("file.encoding", "UTF-8");
        Robot robot = new Robot();
        Random random = new Random();
        Toolkit.getDefaultToolkit().beep();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Long startTime = System.currentTimeMillis();
        int timer = 10*130*60*1000; // 3*60*1000 - 3 min
       // ArrayList<String> finalAneks = ImportAnek.importArrayListFromCSV("src/rusnya.csv");
        ArrayList<String> all = ImportAnek.importArrayList("all.dat");
        Thread backgroundThread = new Thread(() -> {
            while (System.currentTimeMillis() - startTime < timer){
                StringSelection select = new StringSelection(all.get(random.nextInt(all.size())));
                clipboard.setContents(select,select);
                System.out.println(LocalDateTime.now());
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_ENTER);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundThread.start();
    }
}
