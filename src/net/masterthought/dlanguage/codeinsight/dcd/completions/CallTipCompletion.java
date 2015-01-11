package net.masterthought.dlanguage.codeinsight.dcd.completions;

public class CallTipCompletion implements Completion {

    private String completionType;
    private String completionText;

    public CallTipCompletion(String completionType, String completionText) {
        this.completionType = completionType;
        this.completionText = completionText;
    }

    @Override
    public String completionType() {
        return completionType;
    }

    @Override
    public String completionText() {
        return completionText;
    }
}
