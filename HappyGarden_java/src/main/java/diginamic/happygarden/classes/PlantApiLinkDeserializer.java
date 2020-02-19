package diginamic.happygarden.classes;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class PlantApiLinkDeserializer extends StdDeserializer<PlantApiLink> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlantApiLinkDeserializer() {
		this(null);
	}

	public PlantApiLinkDeserializer(Class<?> vc) {
		super(vc);
	}
	
	
	@Override
	public PlantApiLink deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// Object parsed from Json
		JsonNode plantApiLinkNode = p.getCodec().readTree(p);
		// Object to return after filling it from data retrieved from the JsonNode
		PlantApiLink plantApiLink = new PlantApiLink();
		
		plantApiLink.setId(plantApiLinkNode.get("id").longValue());
		plantApiLink.setCompleteData(plantApiLinkNode.get("complete_data").booleanValue());
		plantApiLink.setScientificName(plantApiLinkNode.get("scientific_name").textValue());
		
		return plantApiLink;
	}
}
