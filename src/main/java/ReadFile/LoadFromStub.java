package ReadFile;

import java.util.ArrayList;
import java.util.List;

public class LoadFromStub implements Load{
    @Override
    public List<String> getFileData(String fileName) {
        List<String> stubData = new ArrayList<String>();
        stubData.add("ThisIsAStub@stubStuff.com, Stub Buts, Password1");
        stubData.add("ThisIsAlsoAStub@stubStuff.com, Buts Stub, WeHeartStubs2");
        return stubData;
    }

    @Override
    public List<String> getLastLines(String fileName, int numberOfLines) {
        return null;
    }
}
