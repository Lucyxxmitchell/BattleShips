package ReadFile;

import java.util.ArrayList;
import java.util.List;

public class LoadFromFake implements Load {
    @Override
    public List<String> getFileData(String fileName) {
        List<String> fakeData = new ArrayList<String>();
        fakeData.add("ThisIsAStub@stubStuff.com, Stub Buts, Password1");
        fakeData.add("ThisIsAlsoAStub@stubStuff.com, Buts Stub, WeHeartStubs2");
        return fakeData;
    }

    @Override
    public List<String> getLastLines(String fileName, int numberOfLines) {
        return null;
    }
}
