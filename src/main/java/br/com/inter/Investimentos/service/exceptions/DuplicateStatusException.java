package br.com.inter.Investimentos.service.exceptions;

public class DuplicateStatusException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DuplicateStatusException(String msg) {
        super(msg);
    }

    public DuplicateStatusException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
