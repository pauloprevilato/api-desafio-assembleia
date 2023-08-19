package br.com.sicredi.apiassembleia.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@NoArgsConstructor
public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

	private List<FieldError> fieldErrors;

	public BusinessException(final Exception exception) {
		super(exception);
	}

	public BusinessException(final Exception exception, final HttpStatus httpStatus) {
		super(exception);
		this.httpStatus = httpStatus;
	}

	public BusinessException(final String message) {
		super(message);
	}

	public BusinessException(final String message, final Exception exception) {
		super(message, exception);
	}

	public BusinessException(final String message, final Exception exception, final HttpStatus httpStatus) {
		super(message, exception);
		this.httpStatus = httpStatus;
	}

	public BusinessException(final String message, final HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public BusinessException(final List<FieldError> fieldErrors, final HttpStatus httpStatus) {
		super(HttpStatus.BAD_REQUEST.getReasonPhrase());
		this.fieldErrors = fieldErrors;
		this.httpStatus = httpStatus;
	}

	public BusinessException(final String message, final List<FieldError> fieldErrors, final HttpStatus httpStatus) {
		super(message);
		this.fieldErrors = fieldErrors;
		this.httpStatus = httpStatus;
	}
}