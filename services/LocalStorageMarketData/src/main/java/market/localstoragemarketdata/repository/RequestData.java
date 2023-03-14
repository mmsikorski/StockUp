package market.localstoragemarketdata.repository;

public record RequestData(String date,
                          double open,
                          double close,
                          double low,
                          double high) {
}