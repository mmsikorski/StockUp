package market.localstoragemarketdata.repository;

public class RequestDataMapper {

    RequestData fromRawData(String date,
                            double open,
                            double close,
                            double low,
                            double high) {
        return new RequestData(date, open, close, low, high);
    }
}
