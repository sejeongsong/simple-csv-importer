package domain.entity;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Store {

    private static final List<String> fieldNames;

    private String id;
    private String opnSfTeamCode;
    private String mgtNo;
    private String opnSvcId;
    private String name;
    private String roadAddress;
    private String address;
    private String phone;
    private double x;
    private double y;
    private int status;

    static {
        fieldNames = Arrays.stream(Store.class.getDeclaredFields())
                .map(Field::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    private Store(String id, String opnSfTeamCode, String mgtNo, String opnSvcId, String name, String roadAddress,
            String address, String phone, double x, double y, int status) {
        this.id = id;
        this.opnSfTeamCode = opnSfTeamCode;
        this.mgtNo = mgtNo;
        this.opnSvcId = opnSvcId;
        this.name = name;
        this.roadAddress = roadAddress;
        this.address = address;
        this.phone = phone;
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getOpnSfTeamCode() {
        return opnSfTeamCode;
    }

    public String getMgtNo() {
        return mgtNo;
    }

    public String getOpnSvcId() {
        return opnSvcId;
    }

    public String getName() {
        return name;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getStatus() {
        return status;
    }

    public static StoreBuilder builder() {
        return new StoreBuilder();
    }

    public static class StoreBuilder {

        private String id;
        private String opnSfTeamCode;
        private String mgtNo;
        private String opnSvcId;
        private String name;
        private String roadAddress;
        private String address;
        private String phone;
        private Double x;
        private Double y;
        private Integer status;

        public StoreBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public StoreBuilder withOpnSfTeamCode(String opnSfTeamCode) {
            this.opnSfTeamCode = opnSfTeamCode;
            return this;
        }

        public StoreBuilder withMgtNo(String mgtNo) {
            this.mgtNo = mgtNo;
            return this;
        }

        public StoreBuilder withOpenSvcId(String openSvcId) {
            this.opnSvcId = openSvcId;
            return this;
        }

        public StoreBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public StoreBuilder withRoadAddress(String roadAddress) {
            this.roadAddress = roadAddress;
            return this;
        }

        public StoreBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public StoreBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public StoreBuilder withX(double x) {
            this.x = x;
            return this;
        }

        public StoreBuilder withY(double y) {
            this.y = y;
            return this;
        }

        public StoreBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public Store build() {
            if(Objects.isNull(this.id)
            || Objects.isNull(this.opnSfTeamCode)
            || Objects.isNull(this.mgtNo)
            || Objects.isNull(this.opnSvcId)
            || Objects.isNull(this.name)
            || Objects.isNull(this.x)
            || Objects.isNull(this.y)
            || Objects.isNull(this.status)){
                throw new IllegalStateException();
            }
            return new Store(
                    this.id,
                    this.opnSfTeamCode,
                    this.mgtNo,
                    this.opnSvcId,
                    this.name,
                    this.roadAddress,
                    this.address,
                    this.phone,
                    this.x,
                    this.y,
                    this.status);
        }
    }
}

