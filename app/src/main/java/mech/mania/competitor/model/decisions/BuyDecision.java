package mech.mania.competitor.model.decisions;

import java.util.ArrayList;

public class BuyDecision extends ActionDecision {
    protected ArrayList<String> cropTypes;
    protected ArrayList<Integer> quantities;
    public BuyDecision(ArrayList<String> cropTypes, ArrayList<Integer> quantities) {
        this.cropTypes = cropTypes;
        this.quantities = quantities;
        assert(cropTypes.size() == quantities.size());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("buy ");
        for (int i = 0; i < cropTypes.size(); i++) {
            builder.append(cropTypes.get(i));
            builder.append(" ");
            builder.append(quantities.get(i));
        }

        return builder.toString();
    }
}