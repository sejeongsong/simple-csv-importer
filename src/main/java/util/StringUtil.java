package util;

public enum StringUtil {

    INSTANCE;

    public String trimQuotes(String target) {
        return target.substring(1, target.length() - 1);
    }
}
