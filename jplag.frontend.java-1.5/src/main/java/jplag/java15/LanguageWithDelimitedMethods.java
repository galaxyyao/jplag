package jplag.java15;

import java.io.File;

import jplag.IProgram;

/**
 * Java 1.5 parser with method separators; if you know why these separators
 * exist, PLEASE tell us or document at
 * https://svn.ipd.kit.edu/trac/jplag/wiki/Server/Frontends/Java-1.5)
 */
public class LanguageWithDelimitedMethods implements jplag.Language {
	private Parser parser;

	public LanguageWithDelimitedMethods(IProgram program) {
		this.parser = new Parser(true);
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
		return "Java1.5 Parser with delimited methods";
	}

	@Override
	public String getShortName() {
		return "java15dm";
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
