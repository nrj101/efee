// /Sprint-002/Story-007/source/CorrectionHistory.java

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CorrectionHistory {

    private final List<String> corrections;

    public CorrectionHistory() {
        this.corrections = new ArrayList<>();
    }

    public void addCorrection(String correction) {
        Objects.requireNonNull(correction);

        corrections.add(correction);
    }

    public int size() {
        return corrections.size();
    }

    public List<String> getCorrections() {
        return List.copyOf(corrections);
    }
}