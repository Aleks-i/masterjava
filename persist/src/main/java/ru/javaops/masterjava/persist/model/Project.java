package ru.javaops.masterjava.persist.model;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@NoArgsConstructor
public class Project extends BaseEntity {
    private @NonNull String name;
    private @NonNull String description;
    private List<Group> groups;
}
