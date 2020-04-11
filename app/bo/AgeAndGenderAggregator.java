package bo;

import java.util.List;

public class AgeAndGenderAggregator {
    public long count;
    public String key;
    public List<GenderAggregator> values;

    public AgeAndGenderAggregator(String key, long count, List<GenderAggregator> values) {
        this.count = count;
        this.key = key;
        this.values = values;
    }
}
