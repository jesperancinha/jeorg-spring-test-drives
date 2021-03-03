package org.jesperancinha.std.flash310.jsoncomponent.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringEscapeUtils;
import org.jesperancinha.std.flash310.jsoncomponent.dto.Guitar;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class GuitarJsonConverter {

    public static class Serialize extends JsonSerializer<Guitar> {
        @Override
        public void serialize(Guitar value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            try {
                if (value == null) {
                    jsonGenerator.writeNull();
                } else {
                    jsonGenerator.writeString(value.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class Deserialize extends JsonDeserializer<Guitar> {
        @Override
        public Guitar deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            try {

                final TreeNode node = jsonParser.getCodec().readTree(jsonParser);
                final String unescapedString = StringEscapeUtils.unescapeJava(node.toString());
                final var guitar = unescapedString.substring(0, unescapedString.length());
                return new ObjectMapper().readValue(guitar, Guitar.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
