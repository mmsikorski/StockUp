package market.localstoragemarketdata.repository;

public class RequestDataMapper {

    RequestData fromRawData(String date,
                            String open,
                            String close,
                            String low,
                            String high) {
        return new RequestData(date, open, close, low, high);
    }
}
