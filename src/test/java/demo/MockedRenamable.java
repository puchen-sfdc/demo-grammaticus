package demo;

/**
 * An example to load message file and retrieve the messages.
 *
 * @author pu.chen
 */
import com.force.i18n.HumanLanguage;
import com.force.i18n.Renameable;
import com.force.i18n.grammar.Noun;
import com.force.i18n.grammar.NounForm;

public class MockedRenamable implements Renameable{
	private Noun noun;
	
	MockedRenamable(Noun noun) {
		this.noun = noun;
	}

	@Override
	public String getName() {
		return noun.getName();
	}

	@Override
	public String getLabel() {
		return noun.getDefaultString(false);
	}

	@Override
	public String getLabelPlural() {
		return noun.getDefaultString(true);
	}

	@Override
	public boolean hasStandardLabel() {
		return true;
	}

	@Override
	public String getStandardFieldLabel(HumanLanguage language, StandardField field) {
		return null;
	}

	@Override
	public String getEntitySpecificDbLabelKey(String labelKey) {
		return null;
	}

	@Override
	public StandardField getRenameableFieldForKey(String labelKey) {
		return null;
	}

	@Override
	public Noun getStandardNoun(HumanLanguage language) {
		return noun;
	}

}
