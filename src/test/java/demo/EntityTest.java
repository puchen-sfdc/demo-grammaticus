package demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Locale;

import org.junit.Test;

import com.force.i18n.HumanLanguage;
import com.force.i18n.LabelSet;
import com.force.i18n.LanguageProviderFactory;
import com.force.i18n.Renameable;
import com.force.i18n.grammar.GrammaticalLabelSet;
import com.force.i18n.grammar.RenamingProvider;
import com.force.i18n.grammar.RenamingProviderFactory;

/**
 * An example to load message file and retrieve the messages.
 *
 * @author pu.chen
 */
public class EntityTest extends GrammaticusTest {

	/**
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test
	public void testMessageWithEntity() throws MalformedURLException, IOException {

		HumanLanguage language = LanguageProviderFactory.get().getLanguage(Locale.US);

		LabelSet ls = getLabelSet(language, false);
		String one_en = ls.getString("Global", "one");
		String two_en = ls.getString("Global", "two");

		language = LanguageProviderFactory.get().getLanguage(Locale.GERMAN);

		ls = getLabelSet(language, false);
		String one_de = ls.getString("Global", "one");
		String two_de = ls.getString("Global", "two");
		
		System.out.println();
		System.out.println("Every asset needs <a/> <activity/>, <a/> <contact/>, or both.");
		System.out.println(one_en);
		System.out.println(one_de);
		System.out.println();
		System.out.println("You can't associate <a/> <private/> <contact/> with <a/> <activity/>.");
		System.out.println(two_en);
		System.out.println(two_de);
	}
	
	@Test
	public void testMessageWithEntityParameters() throws MalformedURLException, IOException {
		// Get label set.
		HumanLanguage language = LanguageProviderFactory.get().getLanguage(Locale.GERMAN);
		GrammaticalLabelSet ls = getLabelSet(language, false);
		
		// Create a renamable entity for "activity".	
		Renameable account = new MockedRenamable(ls.getDictionary().getNoun("activity", true));
		
		String result_1 = ls.getString("Global", new Renameable[] {account}, "aentity");
		
		// Create a renamable entity for "contact".
		Renameable contact = new MockedRenamable(ls.getDictionary().getNoun("contact", true)); 
		
		String result_2 = ls.getString("Global", new Renameable[] {contact}, "aentity");
		
		System.out.println();
		System.out.println("<A/> <private/> <entity entity=\"0\" plural=\"n\"/>");
		System.out.println(result_1);
		System.out.println(result_2);
	}
	
	@Test
	public void testMessageWithEntityParametersAAA() throws MalformedURLException, IOException {
		// Get label set.
		HumanLanguage language = LanguageProviderFactory.get().getLanguage(Locale.US);
		GrammaticalLabelSet ls = getLabelSet(language, false);
		
		// Create a renamable entity for "activity".	
		Renameable account = new MockedRenamable(ls.getDictionary().getNoun("activity", true));
		
		String result_1 = ls.getString("Global", "activity");
		
		System.out.println();
		System.out.println(result_1);
	}
}
