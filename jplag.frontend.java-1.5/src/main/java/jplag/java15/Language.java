package jplag.java15;

import java.io.File;

import jplag.IProgram;

public class Language implements jplag.Language {
	private Parser parser;

	public Language(IProgram program) {
		this.parser = new Parser(false);
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
		return "Java1.5 Parser";
	}

	@Override
	public String getShortName() {
		return "java15";
	}

	@Override
	public int min_token_match() {
		return 8;
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
		return jplag.java15.JavaToken.numberOfTokens();
	}

	public String type2string(int type) {
		return jplag.java15.JavaToken.type2string(type);
	}
}
