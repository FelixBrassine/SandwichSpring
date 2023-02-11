package be.technobel.fbrassine.sandwichspring.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final Object innerData;

    public NotFoundException(Object innerData) {
        super("Not Found");
        this.innerData = innerData;
    }
}
