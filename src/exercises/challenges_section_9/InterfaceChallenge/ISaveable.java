package exercises.challenges_section_9.InterfaceChallenge;
import java.util.List;

public interface ISaveable {
    List<String> write();
    void read(List<String> savedValues);
}
