package jplag.scheme;

import java.io.File;

import jplag.IProgram;

public class Language implements jplag.Language {

	public Language(IProgram program) {
		this.parser = new Parser();
		this.parser.setProgram(program);

	}

	@Override
	public int errorsCount() {
		// TODO Auto-generated method stub
		return this.parser.errorsCount();
	}

	private jplag.scheme.Parser parser;//noch nicht instanziert? siehe
									   // Konstruktor

	@Override
	public String[] suffixes() {
		String[] res = { ".scm", ".SCM", ".ss", ".SS" };
		return res;
	}

	@Override
	public String name() {
		return "SchemeR4RS Parser [basic markup]";
	}

	@Override
	public String getShortName() {
		return "scheme";
	}

	@Override
	public int min_token_match() {
		return 13;
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
		return jplag.scheme.SchemeToken.numberOfTokens();
	}

	public String type2string(int type) {
		return jplag.scheme.SchemeToken.type2string(type);
	}
}
