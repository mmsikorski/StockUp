package market.localstoragemarketdata.data;

import market.localstoragemarketdata.data.prices.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LocalStorage {
    public static Map<Date, Open> openPrices = new HashMap<>();
    public static Map<Date, Close> closePrices = new HashMap<>();
    public static Map<Date, Low> lowPrices = new HashMap<>();
    public static Map<Date, High> highPrices = new HashMap<>();
    public static Map<LocalDateTime, Mean> meanRandomPrice = new HashMap<>();
    public static Map<LocalDateTime, High> highRandomPrice = new HashMap<>();
    public static Map<LocalDateTime, Low> lowRandomPrice = new HashMap<>();
    public static Map<LocalDateTime, Close> closeRandomPrice = new HashMap<>();
    public static Map<LocalDateTime, Open> openRandomPrice = new HashMap<>();
}
