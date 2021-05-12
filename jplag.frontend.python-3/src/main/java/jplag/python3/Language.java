package jplag.python3;

import java.io.File;

import jplag.IProgram;

public class Language implements jplag.Language {

    private jplag.python3.Parser parser;

    public Language(IProgram program) {
        this.parser = new jplag.python3.Parser();
        this.parser.setProgram(program);
    }

    @Override
    public String[] suffixes() {
        String[] res = {".py"};
        return res;
    }

    @Override
    public int errorsCount() {
        return this.parser.errorsCount();
    }

    @Override
    public String name() {
        return "Python3 Parser";
    }

    @Override
    public String getShortName() {
        return "python3";
    }

    @Override
    public int min_token_match() {
        return 12;
    }

    public jplag.Structure parse(File dir, String[] files) {
        return this.parser.parse(dir, files);
    }

    @Override
    public boolean errors() {
        return this.parser.getErrors();
    }

    @Override
    public boolean supportsColumns() {
        return true;
    }

    @Override
    public boolean isPreformated() {
        return true;
    }

    @Override
    public boolean usesIndex() {
        return false;
    }

    @Override
    public int noOfTokens() {
        return jplag.python3.Python3Token.numberOfTokens();
    }

    public String type2string(int type) {
        return jplag.python3.Python3Token.type2string(type);
    }
}
