package com.algawork.algalogapi.api.model.input;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class ClienteIdInput {
    @NonNull
    private Long id;
}
