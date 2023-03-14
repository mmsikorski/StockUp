package market.localstoragemarketdata.data.prices;

import lombok.Data;
import market.localstoragemarketdata.data.Price;

@Data
public class Open extends AbstractPrice implements Price {

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
