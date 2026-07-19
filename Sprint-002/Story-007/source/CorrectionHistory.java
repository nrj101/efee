import java.util.List;
import java.util.ArrayList;

public class CorrectionHistory {

    private final List<String> history;

    public CorrectionHistory() {
        this.history = new ArrayList<>();
    }

    public void addCorrection(String correction) {
        history.add(correction);
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }
}
