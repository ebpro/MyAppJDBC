package fr.univtln.bruno;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Person {
    int id;
    String name;
}
