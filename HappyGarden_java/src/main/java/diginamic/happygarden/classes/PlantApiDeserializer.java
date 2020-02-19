package diginamic.happygarden.classes;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import diginamic.happygarden.model.GrowthRate;

public class PlantApiDeserializer extends StdDeserializer<PlantApi> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlantApiDeserializer() {
		this(null);
	}

	public PlantApiDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public PlantApi deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// Object parsed from Json
		JsonNode plantApiNode = p.getCodec().readTree(p);
		// Object to return after filling it from data retrieved from the JsonNode
		PlantApi plantApi = new PlantApi();
		
		plantApi.setScientificName(plantApiNode.get("scientific_name").textValue());
		plantApi.setCommonName(plantApiNode.get("common_name").textValue());
		plantApi.setFamilyCommonName(plantApiNode.get("family_common_name").textValue());
		plantApi.setToxicity(plantApiNode.get("main_species").get("specifications").get("toxicity").textValue());
		plantApi.setMatureHeight(plantApiNode.get("main_species").get("specifications").get("mature_height").get("cm").floatValue());
		plantApi.setLifeSpan(plantApiNode.get("main_species").get("specifications").get("lifespan").textValue());
		if(plantApiNode.get("images").has(0) != false) {
			plantApi.setImage(plantApiNode.get("images").get(0).get("url").textValue());
		}
		plantApi.setBloomPeriod(plantApiNode.get("main_species").get("seed").get("bloom_period").textValue());
		String growthRate = plantApiNode.get("main_species").get("specifications").get("growth_rate").textValue();
		if(growthRate != null) {
			growthRate = growthRate.toLowerCase();
			switch(growthRate) {
			case "slow":
				plantApi.setGrowthRate(GrowthRate.SLOW);
				break;
			case "moderate":
				plantApi.setGrowthRate(GrowthRate.MODERATE);
				break;
			case "rapid":
				plantApi.setGrowthRate(GrowthRate.RAPID);
				break;
			default:
				plantApi.setGrowthRate(null);
			}
		} else {
			plantApi.setGrowthRate(null);
		}
		

	return plantApi;
}

}
