package com.kamadhenu.api.travel.car.dollar.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Maps empty String to integer value zero
 */
public class StringToNumber extends TypeAdapter<Number> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringToNumber.class);

    @Override
    public void write(JsonWriter jsonWriter, Number number) {
    }

    @Override
    public Number read(JsonReader jsonReader) {
        String value = null;
        try {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            value = jsonReader.nextString();

            if (!(value.matches("-?\\d+(\\.\\d+)?"))) {
                return 0;
            }

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return NumberUtils.createNumber(value);
    }
}

