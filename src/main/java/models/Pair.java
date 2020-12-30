package models;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
public class Pair implements Comparable<Pair> {

    @NonNull
    private Integer first;

    @NonNull
    private Integer second;

    @Override
    public int compareTo(Pair o) {
        return (this.first).compareTo(o.first);
    }
}