package br.com.sicredi.apiassembleia.domain;

import br.com.sicredi.apiassembleia.domain.converter.StatusEnumConverter;
import br.com.sicredi.apiassembleia.domain.enumeration.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@MappedSuperclass
public abstract class AbstractDominioEntity<I extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected I id;

    @Column(name = "ID_STATUS")
    @Convert(converter = StatusEnumConverter.class)
    protected StatusEnum status;

}
