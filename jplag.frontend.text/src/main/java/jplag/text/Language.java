
package jplag.text;

import java.io.File;

import jplag.IProgram;

/**
 * @Changed by Emeric Kwemou 29.01.2005
 *  
 */
public class Language implements jplag.Language {

	private IProgram program;

	private jplag.text.Parser parser = new jplag.text.Parser();

	public Language(IProgram program) {
		this.program = program;
		this.parser.setProgram(this.program);
	}

	@Override
	public int errorsCount() {
		return this.parser.errorsCount();
	}

	@Override
	public String[] suffixes() {
		String[] res = { ".TXT", ".txt", ".ASC", ".asc", ".TEX", ".tex" };
		return res;
	}

	@Override
	public String name() {
		return "Text Parser";
	}

	@Override
	public String getShortName() {
		return "text";
	}

	@Override
	public int min_token_match() {
		return 5;
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
		return false;
	}

	@Override
	public boolean usesIndex() {
		return false;
	}

	@Override
	public int noOfTokens() {
        return parser.tokenStructure.serial;
//		return jplag.text.TextToken.numberOfTokens();   // always returns 1 ....
	}

	public String type2string(int type) {
		return jplag.text.TextToken.type2string(type);
	}
}
