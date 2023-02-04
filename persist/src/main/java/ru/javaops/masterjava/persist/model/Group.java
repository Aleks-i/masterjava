package ru.javaops.masterjava.persist.model;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@NoArgsConstructor
public class Group extends BaseEntity {
    private @NonNull String name;
    private @NonNull GroupType type;
    private @NonNull Integer projectId;
}
