/**
 * 
 */
package com.sungale.dropship.convert;

import java.io.FileWriter;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.sungale.dropship.data.UpsCsv;

/**
 * @author Julia Sun
 * 2013 12 27
 */
public class WriteUpsCsv {
	private CellProcessor[] getProcessors() {
        
        final CellProcessor[] processors = new CellProcessor[] { 
                new Optional(), // OrderId
                new NotNull(), // ShipmentInformation_ServiceType
                new NotNull(), // ShipmentInformation_BillingOption
                new Optional(),//ShipmentInformation_QvnOption
                new Optional(),//ShipmentInformation_QvnShipNotification1Option
                new Optional(),//ShipmentInformation_NotificationRecipient1Type
                new Optional(),//ShipmentInformation_NotificationRecipient1FaxorEmail
                new NotNull(),//ShipTo_CompanyOrName
                new NotNull(),//ShipTo_StreetAddress
                new Optional(),//ShipTo_RoomFloorAddress2
                new NotNull(),//ShipTo_City
                new NotNull(),//ShipTo_State
                new NotNull(),//ShipTo_Country
                new NotNull(),//ShipTo_ZipCode
                new Optional(),//ShipTo_Telephone
                new Optional(),//ShipTo_ResidentialIndicator
                new Optional(),//ThirdParty_CompanyOrName
                new Optional(),//ThirdParty_Attention
                new Optional(),//ThirdParty_Address
                new Optional(),//ThirdParty_Address2
                new Optional(),//ThirdParty_Country
                new Optional(),//ThirdParty_PostalCode
                new Optional(), //ThirdParty_City
                new Optional(), //ThirdParty_State
                new Optional(),//ThirdParty_Telephone
                new Optional(),//ThirdParty_UPSAccount
                new NotNull(),//Package_PackageType
                new Optional(),//Package_Weight
                new Optional(),//Package_Reference1
                new Optional(),//Package_Reference2
                new Optional(),//Package_Reference3
                new Optional(),//Package_Reference4
                new Optional(),//Package_Reference5
                new Optional(),//Package_DeclaredValueOption
                new Optional(),//Package_DeclaredValueAmount
                new Optional()//ShipTo_LocationID

        };
        
        return processors;
	}
	public void writeWithCsvBeanWriter(List<UpsCsv> input, String outputPath) throws Exception {
        
        ICsvBeanWriter beanWriter = null;
        try {
                beanWriter = new CsvBeanWriter(new FileWriter(outputPath),
                        CsvPreference.STANDARD_PREFERENCE);
                
                // the header elements are used to map the bean values to each column (names must match)
                final String[] header = new String[] { "OrderId", "ShipmentInformation_ServiceType", "ShipmentInformation_BillingOption", "ShipmentInformation_QvnOption",
                		"ShipmentInformation_QvnShipNotification1Option","ShipmentInformation_NotificationRecipient1Type","ShipmentInformation_NotificationRecipient1FaxorEmail",
                		"ShipTo_CompanyOrName","ShipTo_StreetAddress","ShipTo_RoomFloorAddress2","ShipTo_City","ShipTo_State","ShipTo_Country","ShipTo_ZipCode","ShipTo_Telephone",
                		"ShipTo_ResidentialIndicator","ThirdParty_CompanyOrName","ThirdParty_Attention","ThirdParty_Address","ThirdParty_Address2","ThirdParty_Country",
                		"ThirdParty_PostalCode","ThirdParty_City","ThirdParty_State","ThirdParty_Telephone","ThirdParty_UPSAccount",
                		"Package_PackageType","Package_Weight","Package_Reference1","Package_Reference2","Package_Reference3","Package_Reference4",
                		"Package_Reference5","Package_DeclaredValueOption","Package_DeclaredValueAmount","ShipTo_LocationID"};
                final CellProcessor[] processors = getProcessors();
                
                // write the header
                beanWriter.writeHeader(header);
                
                // write the beans
                for( final UpsCsv ups: input) {
                        beanWriter.write(ups, header, processors);
                }
                
        }
        finally {
                if( beanWriter != null ) {
                        beanWriter.close();
                }
        }
	}
}
