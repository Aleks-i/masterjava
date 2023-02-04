package ru.javaops.masterjava.persist.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@NoArgsConstructor
public class City {
    private @NonNull String id;
    private @NonNull String name;
}
