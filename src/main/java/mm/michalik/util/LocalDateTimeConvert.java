package mm.michalik.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by maciej on 06.09.16.
 */
@Converter(autoApply = true)
public class LocalDateTimeConvert implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        if (attribute == null) return null;
        return Timestamp.valueOf(attribute);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
       if (dbData == null) return null;
        return dbData.toLocalDateTime();
    }
}
