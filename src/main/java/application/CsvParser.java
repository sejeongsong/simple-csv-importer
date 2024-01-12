package application;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import config.CsvConfig;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class CsvParser {

    private final CSVReader csvReader;

    public CsvParser(CsvConfig config) {
        try {
            this.csvReader = new CSVReader(new FileReader(config.getPath().getPath(), Charset.forName("EUC-KR")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] parseNextLine() {
        try {
            return csvReader.readNext();
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

}
