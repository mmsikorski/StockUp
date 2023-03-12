package market.app.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceModelMapper {

    public List<PriceModel> fromStringToListPrice(String prices) throws JsonProcessingException {
        // Create an instance of ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Define the JSON string response
        String jsonResponseResponse = "[{\"date\":\"2022-02-03\",\"open\":\"145.294998\",\"close\":\"142.650497\",\"low\":\"142.205002\",\"high\":\"149.117706\"},{\"date\":\"2022-02-04\",\"open\":\"143.016998\",\"close\":\"143.016006\",\"low\":\"139.817505\",\"high\":\"144.535248\"},{\"date\":\"2022-02-08\",\"open\":\"138.991257\",\"close\":\"139.212997\",\"low\":\"136.873001\",\"high\":\"139.837097\"},{\"date\":\"2022-02-07\",\"open\":\"143.709000\",\"close\":\"138.938004\",\"low\":\"138.699005\",\"high\":\"143.846497\"}]";

        // Create a CollectionType that defines the type of the collection to deserialize into
        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, PriceModel.class);

        // Deserialize the JSON string response into a list of Price objects
        return mapper.readValue(prices, collectionType);
    }
}
