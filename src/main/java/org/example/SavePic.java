package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class SavePic {
    static void savePicFromInet(String link) throws IOException {
        String savePath = "image.jpg";
        // Открываем поток для чтения изображения из URL
        try (InputStream inputStream = new URL(link).openStream();
             OutputStream outputStream = new FileOutputStream(savePath)) {
            // Читаем данные из потока ввода и записываем их в файл
            byte[] buffer = new byte[2048];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
        }
    }
}
