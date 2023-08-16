package br.com.sicredi.apiassembleia.domain.enumeration;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum StatusEnum {

    ATIVO((short) 1, "Ativo"), //
    EXCLUIDO((short) 2, "Excluído"), //
    INATIVO((short) 3, "Inativo");

    private static final Map<Short, StatusEnum> LOOKUP = new HashMap<>();

    static {
        for (StatusEnum e : StatusEnum.values()) {
            LOOKUP.put(e.getId(), e);
        }
    }

    public static StatusEnum valueOfId(Short id) {
        return LOOKUP.get(id);
    }

    private final Short id;
    private final String descricao;

    StatusEnum(Short id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

}

