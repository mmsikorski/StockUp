package market.localstoragemarketdata.data.generator;

import market.localstoragemarketdata.data.Price;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class PriceTickJumpEvent {
    private double value;

    public void receivedGeneratedMarketValue(double value) {
        this.value = value;
    }

    public Function<Float, List<Double>> randomTicksAroundPrice() {
        return value -> List.of(this.value, this.value, this.value, this.value);
    }
}
