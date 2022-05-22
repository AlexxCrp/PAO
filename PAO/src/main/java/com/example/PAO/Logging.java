package com.example.PAO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {

    public Logging() {
    }

    public void writeStudentGet(LocalDateTime timp, String actiune) {
        try {
            FileWriter fisier = new FileWriter(
                    "C:\\Users\\alexc\\Desktop\\PAO\\src\\main\\java\\com\\example\\PAO\\Logging.txt", true);
            BufferedWriter bw = new BufferedWriter(fisier);

            DateTimeFormatter timpFormatatAux = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            String timpFormatat = timp.format(timpFormatatAux);

            bw.write(actiune + "|" + timpFormatat);
            bw.newLine();
            bw.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }


}
