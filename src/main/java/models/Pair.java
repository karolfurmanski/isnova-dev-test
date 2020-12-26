package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair implements Comparable<Pair> {
    private Integer first;
    private Integer second;

    @Override
    public int compareTo(Pair o) {
        return (this.first).compareTo(o.first);
    }
}