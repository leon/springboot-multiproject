package se.radley.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Long> {

	@Override
	public Long convertToDatabaseColumn(LocalDateTime date) {
		if (date == null) {
			return null;
		}
		return date.toEpochSecond(ZoneOffset.UTC);
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Long timestamp) {
		if (timestamp == null || timestamp == 0) {
			return null;
		}
		return LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC);
	}
}
