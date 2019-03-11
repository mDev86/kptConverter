package converter.kpt.utils;

import converter.kpt.exceptions.CustomException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FSHelper {

    public static Path createPathByCadastral(String basePath, String cadastral) throws CustomException {
        Path baseFld = Paths.get(basePath);
        if (!Files.exists(baseFld)) {
            throw new CustomException("Папка " + basePath + " не существует");
        }
        if (!Files.isDirectory(baseFld)) {
            throw new CustomException("Папка " + basePath + " не является папкой");
        }

        String subs =  cadastral.replace(":", File.separator);
        Path dest = Paths.get(basePath, subs, new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(Calendar.getInstance().getTime()));
        try {
            Files.createDirectories(dest);
        } catch (IOException ex) {
            throw new CustomException("Ошибка создания структуры каталогов для кадастрового №" + cadastral, ex);
        }
        return dest;
    }

    public static void saveTextFile(File file, String content) throws CustomException {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file, "UTF-8");
        } catch (Exception ex) {
            throw new CustomException("Ошибка создания файла " + file.getAbsolutePath(), ex);
        }
        writer.println(content);
        writer.close();
    }
}
