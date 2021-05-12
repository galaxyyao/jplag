package jplag.java19;

import java.io.File;

import jplag.IProgram;
import jplag.Structure;

/**
 * Hello world!
 *
 */
public class Language implements jplag.Language {
	private Parser parser;

	public Language(IProgram program) {
		this.parser = new Parser();
		this.parser.setProgram(program);

	}
	
    @Override
	public String[] suffixes() {
    	String[] res = { ".java", ".JAVA" };
		return res;
	}

	@Override
	public String name() {
		return "Javac 1.9+ based AST plugin";
	}

	@Override
	public String getShortName() {
		return "java19";
	}

	@Override
	public int min_token_match() {
		return 9;
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
		return JavaToken.numberOfTokens();
	}

	public String type2string(int type) {
		return JavaToken.type2string(type);
	}


	public Structure parse(File dir, String[] files) {
		return this.parser.parse(dir, files);
	}

	@Override
	public boolean errors() {
		return this.parser.getErrors();
	}

	@Override
	public int errorsCount() {
		return this.parser.errorsCount();
	}

}
