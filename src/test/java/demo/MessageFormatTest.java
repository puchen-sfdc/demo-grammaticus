package demo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import org.junit.Test;

import com.force.i18n.HumanLanguage;
import com.force.i18n.LabelSet;
import com.force.i18n.LabelSetDescriptorImpl;
import com.force.i18n.LanguageLabelSetDescriptor.GrammaticalLabelSetDescriptor;
import com.force.i18n.LanguageProviderFactory;
import com.force.i18n.grammar.GrammaticalLocalizerFactory;
import com.force.i18n.grammar.parser.GrammaticalLabelSetLoader;

/**
 * An example to load message file and retrieve the messages.
 *
 * @author pu.chen
 */
public class MessageFormatTest extends GrammaticusTest {

	/**
	 * Test case to load English message set and validate the retrieved message.
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test
	public void testEnglishMessage() throws MalformedURLException, IOException {

		HumanLanguage language = LanguageProviderFactory.get().getLanguage(Locale.US);
		String msg = getLabelSet(language, false).getString("Icons", "colorPicker");
		
		assertTrue("Got the wrong message.", msg.equals("Choose a Color"));
	}
	
	/**
	 * Test case to load Chinese message set and validate the retrieved message.
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test
	public void testChineseMessage() throws MalformedURLException, IOException {

		HumanLanguage language = LanguageProviderFactory.get().getLanguage(Locale.SIMPLIFIED_CHINESE);
		String msg = getLabelSet(language, false).getString("Icons", "colorPicker");
		
		assertTrue("Got the wrong message.", msg.equals("选取颜色"));
	}
	
	/**
	 * Test case to load English message set through cached loader.
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test 
	public void testCachedLoader() throws MalformedURLException, IOException {
		HumanLanguage language = LanguageProviderFactory.get().getLanguage(Locale.US);
		String msg = getLabelSet(language, true).getString("Icons", "colorPicker");
		
		assertTrue("Got the wrong message.", msg.equals("Choose a Color"));
	}
	
	/**
	 * Test case to load English message with entities.
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Test
	public void testMessageWithEntity() throws MalformedURLException, IOException {

		// English
		HumanLanguage language = LanguageProviderFactory.get().getLanguage(Locale.US);
		
		LabelSet ls = getLabelSet(language, false);	
		System.out.println(ls.getString("Global", "activity"));
		System.out.println(ls.getString("Global", "contact"));
		
		// German
		language = LanguageProviderFactory.get().getLanguage(Locale.GERMAN);
		
		ls = getLabelSet(language, false);
		System.out.println(ls.getString("Global", "activity"));
		System.out.println(ls.getString("Global", "contact"));
	}
}
