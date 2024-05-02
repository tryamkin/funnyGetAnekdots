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
        //  ArrayList<String> aneks = new ArrayList<>();
        //  aneks = ImportAnek.importArrayListFromCSV("rusnya.csv");
        //  System.out.println(aneks.size());
        Random random = new Random();
        //  int index = random.nextInt(aneks.size());
        //  System.out.println("Index random - " + index + "   " + aneks.get(index) );
        Toolkit.getDefaultToolkit().beep();
        // StringSelection selection = new StringSelection(aneks.get(index));
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        //  clipboard.setContents(selection,selection);
        Long startTime = System.currentTimeMillis();
        int timer = 10*130*60*1000; // 3*60*1000 - 3 min
        ArrayList<String> finalAneks = ImportAnek.importArrayListFromCSV("rusnya.csv");
        //ArrayList<String> finalAneks = ImportAnek.importArrayListFromCSV("anekMap.csv");
        Thread backgroundThread = new Thread(() -> {
            while (System.currentTimeMillis() - startTime < timer){
                // System.out.println(finalAneks.get(random.nextInt(finalAneks.size())));
                StringSelection select = new StringSelection(finalAneks.get(random.nextInt(finalAneks.size())));
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
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundThread.start();
    }
}
