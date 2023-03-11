package market.localstoragemarketdata.repository;

public record RequestData(String date,
                          String open,
                          String close,
                          String low,
                          String high) {
}