package org.jesperancinha.std.flash319.bean.staticbean.model;

public class Harvest {

    private String goal;

    public Harvest() {
    }

    public Harvest(String goal) {
        this.goal = goal;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "Harvest{" +
                "goal='" + goal + '\'' +
                '}';
    }
}
