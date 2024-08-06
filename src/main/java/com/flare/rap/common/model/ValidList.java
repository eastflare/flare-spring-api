package com.flare.rap.common.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.experimental.Delegate;

@Data
public class ValidList<T> implements List<T> {

    @Valid
    @Delegate
    private List<T> list = new ArrayList<>();

}