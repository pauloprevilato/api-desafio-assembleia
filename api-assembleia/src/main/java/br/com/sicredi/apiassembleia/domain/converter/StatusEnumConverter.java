package br.com.sicredi.apiassembleia.domain.converter;

import br.com.sicredi.apiassembleia.domain.enumeration.StatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusEnumConverter implements AttributeConverter<StatusEnum, Short> {

    @Override
    public Short convertToDatabaseColumn(final StatusEnum statusEnum) {
        return statusEnum != null ? statusEnum.getId() : null;
    }

    @Override
    public StatusEnum convertToEntityAttribute(final Short id) {
        return StatusEnum.valueOfId(id);
    }

}
