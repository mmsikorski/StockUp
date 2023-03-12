package market.app.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceModel {

    String open;
    String close;
    String low;
    String high;
    String date;

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
