package application;

import config.CsvConfig;
import domain.Repository;
import domain.entity.Store;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class StoreImporter extends CsvImporter<Store>{
    // TODO 상속 말고 컴포지션(전략 패턴)으로 리팩토링

    public StoreImporter(CsvConfig csvConfig, CsvParser csvParser, Repository<Store> repository) {
        super(csvConfig, csvParser, repository);
    }

    @Override
    Store convert(String[] parsedLine) {
        Map<String, String> parsed = map(columns, parsedLine);
        return createStore(parsed);
    }

    private Map<String, String> map(String[] columns, String[] parsedLine) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < columns.length; i++) {
            result.put(columns[i], parsedLine[i]);
        }
        return result;
    }

    private Store createStore(Map<String, String> parsed) {
        return Store.builder()
                .withId(UUID.randomUUID().toString())
                .withOpnSfTeamCode(parsed.get("개방자치단체코드"))
                .withOpenSvcId(parsed.get("개방서비스아이디"))
                .withMgtNo(parsed.get("관리번호"))
                .withName(parsed.get("사업장명"))
                .withRoadAddress(parsed.get("도로명전체주소"))
                .withAddress(parsed.get("소재지전체주소"))
                .withPhone(parsed.get("소재지전화"))
                .withX(parseDouble(parsed.get("좌표정보(x)")))
                .withY(parseDouble(parsed.get("좌표정보(y)")))
                .withStatus(Integer.parseInt(parsed.get("상세영업상태코드")))
                .build();
    }

    private double parseDouble(String string) {
        return Objects.isNull(string) || string.isBlank() ? 0 : Double.parseDouble(string);
    }
}
