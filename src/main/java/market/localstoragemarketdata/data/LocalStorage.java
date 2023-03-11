package market.localstoragemarketdata.data;

import market.localstoragemarketdata.data.prices.*;

import java.util.HashMap;
import java.util.Map;

public class LocalStorage {
    public static Map<Date, Open> openPrices = new HashMap<>();
    public static Map<Date, Close> closePrices = new HashMap<>();
    public static Map<Date, Low> lowPrices = new HashMap<>();
    public static Map<Date, High> highPrices = new HashMap<>();
}
