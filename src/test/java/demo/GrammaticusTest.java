package demo;
/**
 * An example to load message file and retrieve the messages.
 *
 * @author pu.chen
 */
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.force.i18n.HumanLanguage;
import com.force.i18n.LabelSetDescriptorImpl;
import com.force.i18n.LanguageLabelSetDescriptor.GrammaticalLabelSetDescriptor;
import com.force.i18n.LanguageProviderFactory;
import com.force.i18n.grammar.GrammaticalLabelSet;
import com.force.i18n.grammar.GrammaticalLocalizerFactory;
import com.force.i18n.grammar.parser.GrammaticalLabelSetLoader;

public class GrammaticusTest {
	private static final String SET_NAME = "sample";
	private static final String MESSAGES = "labels.xml";
	private static final String NAMES = "names.xml";
	private static final String BASE_DIR = "src/test/resources/labels";
	
	GrammaticalLabelSet getLabelSet(HumanLanguage language, boolean cached) throws MalformedURLException, IOException {
		// Where to load the message files and entity definitions.
		URL dir = new File(BASE_DIR).getCanonicalFile().toURI().toURL();
		
		// Load message files and entities.
		HumanLanguage ENGLISH_US = LanguageProviderFactory.get().getBaseLanguage();
		GrammaticalLabelSetDescriptor gls = new LabelSetDescriptorImpl(dir, ENGLISH_US, SET_NAME, MESSAGES, NAMES);
		
		// Get message set loader.
		GrammaticalLabelSetLoader loader = null;
		if (cached) {
			loader = GrammaticalLocalizerFactory.getLoader(gls, null);
		} else {
			loader = new GrammaticalLabelSetLoader(gls);
		}
		
		assert loader != null;
		// Return the loaded message set for given language.
		return loader.getSet(language);		
	}
}
