package com.sungale.dropship.convert;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.sungale.dropship.data.NmrCsv;
import com.sungale.dropship.data.UpsCsv;
/**
 * 
 * @author Julia Sun
 * 2013 12 18
 */
public class ReadNmrCsv {

	private static final String CSV_FILENAME = "C:\\drop-ship\\nmr\\fulfillment-rspa_inc_sungale-2014Jan.csv";
	  	
	  	
	public static void main(String[] args) throws Exception {
		ReadNmrCsv test = new ReadNmrCsv();
		List<UpsCsv> list = test.readWithCsvBeanReader();
		WriteUpsCsv writer = new WriteUpsCsv();
		writer.writeWithCsvBeanWriter(list, "C:\\drop-ship\\UPS\\writeWithCsvBeanWriter.csv");
  	}
  	
  	/**
  	 * @return the cell processors
  	 */
	private static CellProcessor[] getProcessors() {
		final CellProcessor[] processors = new CellProcessor[] { 
  									new NotNull(), // reference_id
  									new NotNull(),	//order_id
  									new NotNull(), 	//shipment_id
  									new Optional(),	//shipment_tracking_id
  									new Optional(),	//shipment_sent_on
  									new Optional(),	//shipment_cost
  									new NotNull(), // shipping_first_name
  						  			new NotNull(), // shipping_last_name
  						  			new NotNull(), //shipping_address_street
  						  			new Optional(), //shipping_address_street_cont
  						  			new NotNull(), 	//shipping_city
  						  			new NotNull(),	//shipping_state
  						  			new NotNull(),	//shipping_postal_code
  						  			new NotNull(),	//shipping_country
  						  			new NotNull(),	//shipping_country_name
  						  			new NotNull(),	//product_sku
  						  			new NotNull(),	//warehouse_sku
  						  			new NotNull(),	//warehouse_id
  						  			new NotNull(),	//warehouse_name
  						  			new NotNull(new ParseInt()),	//product_quantity
  						  			new NotNull(),	//product_name
  						  			new NotNull(),	//product_description
  						  			new NotNull(new ParseDouble()),	//product_cost
  						  			new NotNull(),	//customer_phone_number
  						  			new NotNull(),	//order_date
//  						  			new ParseDate("dd/MM/yyyy HH:mm:SS a"), // order_date
  						  			new Optional()	//carrier
  						  		};
  		
  		return processors;
  	}
  	
  	public List<UpsCsv> readWithCsvBeanReader() throws Exception {
  		
  		ICsvBeanReader beanReader = null;
  		try {
  			beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE);
  			
  			// the header elements are used to map the values to the bean (names must match)
  			final String[] header = beanReader.getHeader(true);
  			final CellProcessor[] processors = getProcessors();
  			
  			NmrCsv nomo;
  			List<UpsCsv> upslist = new ArrayList<UpsCsv>();
  			while( (nomo = beanReader.read(NmrCsv.class, header, processors)) != null ) {
  				System.out.println(String.format("lineNo=%s, rowNo=%s, dropship=%s", beanReader.getLineNumber(),
 					beanReader.getRowNumber(), nomo));
  				UpsCsv ups = this.nmrCsvToUpsCsv(nomo);
  				upslist.add(ups);
 			}
 			return upslist;
 		}
 		finally {
 			if( beanReader != null ) {
 				beanReader.close();
 			}
 		}
 	}
  	
  	
  	
  	
  	private UpsCsv nmrCsvToUpsCsv(NmrCsv nomo){
  		UpsCsv ups = new UpsCsv();
  		//ShipTo info come directly from Nomorerack CSV
  		ups.setShipTo_CompanyOrName(nomo.getShipping_first_name()+" "+nomo.getShipping_last_name());
  		ups.setShipTo_StreetAddress(nomo.getShipping_address_street());
  		ups.setShipTo_RoomFloorAddress2(nomo.getShipping_address_street_cont());
  		ups.setShipTo_City(nomo.getShipping_city());
  		ups.setShipTo_State(nomo.getShipping_state());
  		ups.setShipTo_ZipCode(nomo.getShipping_postal_code());
  		ups.setShipTo_Country(nomo.getShipping_country());
  		ups.setShipTo_Telephone(nomo.getCustomer_phone_number());
  		//use Nomorerack referece_id as ups packaage_reference1
  		ups.setPackage_Reference1(nomo.getReference_id());
  		//residence indicator are default to yes
  		ups.setShipTo_ResidentialIndicator("y");
  		
  		//TODO: improve to calculate product weight
  		ups.setPackage_Weight(1.00);
  		
  		//Shipment are default to be UPS Ground pakcage pay by Shipper for now
  		ups.setPackage_PackageType("Package");
  		ups.setShipmentInformation_ServiceType("Ground");
  		ups.setShipmentInformation_BillingOption("PP");
  		
  		//Set the leftover fields
//  		ups.setOrderId(null);
//  		ups.setShipmentInformation_NotificationRecipient1FaxorEmail(null);
//  		ups.setShipmentInformation_NotificationRecipientType(null);
//  		ups.setShipmentInformation_QvnOption(null);
//  		ups.setShipmentInformation_QvnShipNotification1Option(null);
  		return ups;
  	}
  	
//  	private Double matchSungaleProduct(String nmrSku){
//  		
//  	}
}
