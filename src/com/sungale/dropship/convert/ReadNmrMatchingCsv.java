/**
 * 
 */
package com.sungale.dropship.convert;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.sungale.dropship.data.MatchingCsv;
import com.sungale.dropship.data.NmrCsv;
import com.sungale.dropship.data.UpsCsv;

/**
 * @author Julia Sun
 * 2013 12 30
 */
public class ReadNmrMatchingCsv {

	private static final String MATCHING_FILENAME = "C:\\drop-ship\\UPS\\nmr-model-matching.csv";
	
	private static CellProcessor[] getProcessors() {
		final CellProcessor[] processors = new CellProcessor[] { 
  									new NotNull(), // Sungale Product Model Number
  									new NotNull(),	//NMR product name
  									new Optional(), 	//NMR product description
  									new NotNull(),	//NMR SKU
  									new NotNull(new ParseDouble())//Product unit weight
		};
		return processors;
	}
	
	public void readWithCsvBeanReader() throws Exception {
  		
  		ICsvBeanReader beanReader = null;
  		try {
  			beanReader = new CsvBeanReader(new FileReader(MATCHING_FILENAME), CsvPreference.STANDARD_PREFERENCE);
  			
  			// the header elements are used to map the values to the bean (names must match)
  			final String[] header = beanReader.getHeader(true);
  			final CellProcessor[] processors = getProcessors();
  			
  			MatchingCsv nomo;
  			while( (nomo = beanReader.read(MatchingCsv.class, header, processors)) != null ) {
  				System.out.println(String.format("lineNo=%s, rowNo=%s, matching=%s", beanReader.getLineNumber(),
 					beanReader.getRowNumber(), nomo));
 			}
 		}
 		finally {
 			if( beanReader != null ) {
 				beanReader.close();
 			}
 		}
 	}
	
	public static void main(String[] args) throws Exception{
		ReadNmrMatchingCsv test = new ReadNmrMatchingCsv();
		test.readWithCsvBeanReader();
	}
}
