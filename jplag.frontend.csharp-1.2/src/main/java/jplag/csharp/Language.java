package jplag.csharp;

import java.io.File;

import jplag.IProgram;

public class Language implements jplag.Language {
	private Parser parser;

	public Language(IProgram program) {
		this.parser = new Parser();
		this.parser.setProgram(program);

	}

	@Override
	public String[] suffixes() {
		String[] res = { ".cs", ".CS" };
		return res;
	}

	@Override
	public int errorsCount() {
		// TODO Auto-generated method stub
		return this.parser.errorsCount();
	}

	@Override
	public String name() {
		return "C# 1.2 Parser";
	}

	@Override
	public String getShortName() {
		return "c#-1.2";
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
		return parser.getErrors();
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
		return jplag.csharp.CSharpToken.numberOfTokens();
	}

	public String type2string(int type) {
		return jplag.csharp.CSharpToken.type2string(type);
	}
}
