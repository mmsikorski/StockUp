package market.localstoragemarketdata.data;

import market.localstoragemarketdata.data.localfile.CsvPricesExtractor;

public class StorageRunner {
    public StorageRunner() {
        CsvPricesExtractor csvPricesExtractor = new CsvPricesExtractor();
        csvPricesExtractor.getPrices();
    }
}
