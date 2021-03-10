package org.jesperancinha.std.flash415.http.converter.domain;

import java.util.Set;

public class TearDropReport {

    private Long totalCount;

    private Long average;

    private Long stdDeviation;

    private Set<TearDropType> tearDropTypeSet;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getAverage() {
        return average;
    }

    public void setAverage(Long average) {
        this.average = average;
    }

    public Long getStdDeviation() {
        return stdDeviation;
    }

    public void setStdDeviation(Long stdDeviation) {
        this.stdDeviation = stdDeviation;
    }

    public Set<TearDropType> getTearDropTypeSet() {
        return tearDropTypeSet;
    }

    public void setTearDropTypeSet(Set<TearDropType> tearDropTypeSet) {
        this.tearDropTypeSet = tearDropTypeSet;
    }
}

