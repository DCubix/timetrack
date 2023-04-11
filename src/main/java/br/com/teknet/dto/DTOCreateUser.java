package br.com.teknet.dto;

import javax.validation.constraints.NotBlank;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record DTOCreateUser(
    @NotBlank String name,
    @NotBlank String email,
    @NotBlank String password
) {
}
