package mm.michalik.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.sql.Date;

/**
 * Created by maciej on 12.09.16.
 */
@Converter(autoApply = true)
public class LocalDateToDateConverter implements AttributeConverter<LocalDate,Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        return (attribute==null ? null : Date.valueOf(attribute));
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {

        return (dbData==null ? null : dbData.toLocalDate());
    }
}
