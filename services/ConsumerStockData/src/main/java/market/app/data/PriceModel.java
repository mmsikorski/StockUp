package market.app.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceModel {

    String open;
    double close;
    double low;
    double high;
    double date;

    @Override
    public String toString() {
        return "PriceModel{" +
                "open='" + open + '\'' +
                ", close='" + close + '\'' +
                ", low='" + low + '\'' +
                ", high='" + high + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
