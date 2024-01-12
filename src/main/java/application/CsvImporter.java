package application;

import config.CsvConfig;
import domain.Repository;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

public abstract class CsvImporter<T> {

    private URL path;
    private Repository<T> repository;
    protected String[] columns;
    protected CsvParser csvParser;

    protected CsvImporter(CsvConfig config, CsvParser csvParser, Repository<T> repository) {
        this.path = config.getPath();
        this.csvParser = csvParser;
        this.repository = repository;
    }

    public void toDatabase() {
        try (
                FileInputStream fileInputStream = new FileInputStream(path.getPath());
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        ) {
                // 1. csv 파일의 첫 라인(column)을 읽는다.
            String[] parsedLine = csvParser.parseNextLine();
            initColumns(parsedLine);
                // 2. csv 파일의 라인(row)를 읽는다.
            while (Objects.nonNull(parsedLine =  csvParser.parseNextLine())) {
                // 3. 라인을 엔티티로 변환한다.
                T converted = convert(parsedLine);
                // 4. db에 저장한다.
                repository.save(converted);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    abstract T convert(String[] parsed);

    private void initColumns(String[] columns) {
        this.columns = columns;
    }

}


