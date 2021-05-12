package jplag.javax;

import java.io.*;

import jplag.IProgram;

public class Language implements jplag.Language {
	private Parser parser;

	public Language(IProgram program) {
		this.parser = new Parser();
		this.parser.setProgram(program);

	}

	@Override
	public int errorsCount() {
		return this.parser.errorsCount();
	}

	@Override
	public String[] suffixes() {
		String[] res = { ".java", ".jav", ".JAVA", ".JAV" };
		return res;
	}

	@Override
	public String name() {
		return "experimental Java1.1";
	}

	@Override
	public String getShortName() {
		return "Java1.1(exp)";
	}

	@Override
	public int min_token_match() {
		return 15;
	}

	@Override
	public boolean supportsColumns() {
		return false;
	}

	@Override
	public boolean isPreformated() {
		return true;
	}

	@Override
	public boolean usesIndex() {
		return false;
	}

	public jplag.Structure parse(File dir, String[] files) {
		return this.parser.parse(dir, files);
	}

	@Override
	public boolean errors() {
		return this.parser.getErrors();
	}

	@Override
	public int noOfTokens() {
		return jplag.javax.JavaToken.numberOfTokens();
	}

	public String type2string(int type) {
		return jplag.javax.JavaToken.type2string(type);
	}
}
