package br.com.sicredi.apiassembleia.exceptions;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class FieldError {

	private String field;
	private String error;

}
