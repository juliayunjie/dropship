/**
 * 
 */
package com.sungale.dropship.convert;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sungale.dropship.data.NmrCsv;
import com.sungale.dropship.data.ShopHqOrder;
import com.sungale.dropship.data.UpsCsv;
import com.sungale.dropship.data.UpsShippingCsv;

/**
 * @author Julia Sun
 * 2014 10 02
 */
public class ProcessShopHq {
	private String outputPath;
	public ProcessShopHq(String outputPath){
		this.outputPath = outputPath;
	}
	
	private Document writeSingleInvoice(Document doc, Element rootElement, ShopHqOrder shopHq, UpsShippingCsv ups){
		// hubInvoice elements
					Element hubInvoice = doc.createElement("hubInvoice");
					rootElement.appendChild(hubInvoice);
					
					//participatingParty elements
					Element participatingParty = doc.createElement("participatingParty");
					hubInvoice.appendChild(participatingParty);
					participatingParty.setAttribute("name", "shopHQ");
					participatingParty.setAttribute("participationCode", "To:");
					participatingParty.setAttribute("roleType", "merchant");
					participatingParty.appendChild(doc.createTextNode("snbc"));
					
					//partnerTrxId elements
					Element partnerTrxId = doc.createElement("partnerTrxID");
					hubInvoice.appendChild(partnerTrxId);
					partnerTrxId.appendChild(doc.createTextNode(shopHq.getTrxId()));	
					
					// partnerTrxDate elements
					Element partnerTrxDate = doc.createElement("partnerTrxDate");
					partnerTrxDate.appendChild(doc.createTextNode(shopHq.getTrxDate()));	
					hubInvoice.appendChild(partnerTrxDate);
			 
					// poNumber elements
					Element poNumber = doc.createElement("poNumber");
					poNumber.appendChild(doc.createTextNode(shopHq.getPoNumber()));	
					hubInvoice.appendChild(poNumber);
			 
					// trxShipping elements
					Element trxShipping = doc.createElement("trxShipping");
					double shippingCost = 0.00; 
					if(ups!=null && ups.getShipmentInformationBillingOption().trim().equals("Bill Shipper Freight"))
						shippingCost = Double.parseDouble(ups.getPackagePackagePublishedCharge());
					trxShipping.appendChild(doc.createTextNode(shippingCost+""));	
					hubInvoice.appendChild(trxShipping);
					
					//trxBalanceDue elements
					Element trxBalanceDue = doc.createElement("trxBalanceDue");
					hubInvoice.appendChild(trxBalanceDue);
					Double balanceDue = shippingCost +shopHq.getUnitCost();
					balanceDue = Math.round(balanceDue*100.0)/100.0;
					trxBalanceDue.appendChild(doc.createTextNode(balanceDue.toString()));	 
					
					// hubAction elements
					Element hubAction = doc.createElement("hubAction");
					hubInvoice.appendChild(hubAction);
			 
					// action elements
					Element action = doc.createElement("action");
					action.appendChild(doc.createTextNode("v_invoice"));	
					hubAction.appendChild(action);
			 
					// merchantLineNumber elements
					Element merchantLineNumber = doc.createElement("merchantLineNumber");
					merchantLineNumber.appendChild(doc.createTextNode(shopHq.getMerchantLineNumber()));	
					hubInvoice.appendChild(merchantLineNumber);
			 
					//trxVendorSKU elements
					Element trxVendorSKU = doc.createElement("trxVendorSKU");
					hubAction.appendChild(trxVendorSKU);
					trxVendorSKU.appendChild(doc.createTextNode(shopHq.getVendorSku()));	 
					
					// trxMerchantSKU elements
					Element trxMerchantSKU = doc.createElement("trxMerchantSKU");
					hubAction.appendChild(trxMerchantSKU);
					trxMerchantSKU.appendChild(doc.createTextNode(shopHq.getMerchantSku())); 
			 
					// trxQty elements
					Element trxQty = doc.createElement("trxQty");
					trxQty.appendChild(doc.createTextNode(shopHq.getQtyOrdered().toString()));		
					hubAction.appendChild(trxQty);
			 
					// trxUnitCost elements
					Element trxUnitCost = doc.createElement("trxUnitCost");
					trxUnitCost.appendChild(doc.createTextNode(shopHq.getUnitCost().toString()));	
					hubAction.appendChild(trxUnitCost);
					
					// merchantLineNumber elements
					Element trxLineShipping = doc.createElement("trxLineShipping");
					trxLineShipping.appendChild(doc.createTextNode("0.00"));	
					hubAction.appendChild(trxLineShipping);
			 
					//trxLineTax elements
					Element trxLineTax = doc.createElement("trxLineTax");
					hubAction.appendChild(trxLineTax);
					trxLineTax.appendChild(doc.createTextNode("0.00"));	 
					
					// trxLineMiscCharges elements
					Element trxLineMiscCharges = doc.createElement("trxLineMiscCharges");
					hubAction.appendChild(trxLineMiscCharges);
					trxLineMiscCharges.appendChild(doc.createTextNode("0.00")); 
			 
					
			return doc;
	}
	
	public void readOrderAndGenerateInvoiceXml(String orderFilePath, String upsShipmentFilePath){
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// create root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("InvoiceMessageBatch");
			doc.appendChild(rootElement);
	 
			Element partner= doc.createElement("partnerID");
			rootElement.appendChild(partner);
			partner.setAttribute("name", "RSPA, Inc. (Sungale)");
			partner.setAttribute("roleType", "vendor");
			partner.appendChild(doc.createTextNode("rspainc"));
	 
			List<ShopHqOrder> orders = this.getOrderList(orderFilePath);
			for(ShopHqOrder order: orders){
				UpsShippingCsv ups = this.findUpsShipping(order, upsShipmentFilePath); 
//System.out.println(ups);
				
				doc = this.writeSingleInvoice(doc, rootElement, order, ups);
			}
			
			// finish root elements
			Element messageCount = doc.createElement("messageCount");
			messageCount.appendChild(doc.createTextNode(""+orders.size()));		
			rootElement.appendChild(messageCount);
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
//			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(outputPath+this.getOrderFileName(orderFilePath)+"_invoice.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("Invoice saved::"+outputPath+this.getOrderFileName(orderFilePath)+"_invoice.xml");
	 
		  } catch (Exception pce) {
			pce.printStackTrace();
		  } 
	}
	
	
	private static CellProcessor[] getProcessors() {
		final CellProcessor[] processors = new CellProcessor[] { 
  									new Optional(), 
  									new Optional(),	
  									new Optional(), 
  									new Optional(),	
  									new Optional(),	
  									new Optional(),	
  									new Optional(), 
  						  			new Optional(), 
  						  			new Optional(), 
  						  			new Optional(), 
  						  			new Optional(), 	
  						  			new Optional(),	
  						  			new Optional(),	
  						  			new Optional(),	
  						  			new Optional(),	
  						  			new Optional(),
  						  			new Optional(),	
  						  			new Optional()	
  						  				
  						  		};
  		
  		return processors;
  	}
	
	private UpsShippingCsv findUpsShipping(ShopHqOrder order, String upsShipmentFilePath) throws Exception{
		UpsShippingCsv rtn = new UpsShippingCsv();
		ICsvBeanReader beanReader = null;
  		try {
  			beanReader = new CsvBeanReader(new FileReader(upsShipmentFilePath), CsvPreference.STANDARD_PREFERENCE);
  			
  			final String[] header = beanReader.getHeader(true);
  			final CellProcessor[] processors = getProcessors();
  			
  			UpsShippingCsv ups;
			String match1 = this.makePackageReference1(order);
			String match2 = this.makePackageReference2(order);
//System.out.println(match1+"---"+match2);			
  			while( (ups = beanReader.read(UpsShippingCsv.class, header, processors)) != null ) {
//  				System.out.println(String.format("lineNo=%s, rowNo=%s, dropship=%s", beanReader.getLineNumber(),beanReader.getRowNumber(), ups));
  				
  				if(ups.getPackageReference1().trim().equals(match1) && ups.getPackageReference2().trim().equals(match2)){
  					rtn = ups;
  					break;
  				}
 			}
 		}
 		finally {
 			if( beanReader != null ) {
 				beanReader.close();
 			}
 		}
		
		
		return rtn;
	}
		
	private List<ShopHqOrder> getOrderList(String orderFilePath) throws Exception{
		List<ShopHqOrder> rtn = new ArrayList<ShopHqOrder>();
		File fXmlFile = new File(orderFilePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
	 
		doc.getDocumentElement().normalize();
	 
//		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	 
		NodeList nList = doc.getElementsByTagName("hubOrder");
//		System.out.println("----------------------------");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			 
			Node nNode = nList.item(temp);
	 
//			System.out.println("\nCurrent Element :" + nNode.getNodeName());
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;

				Element shipTo = (Element)eElement.getElementsByTagName("shipTo").item(0);
				String shipToPersonPlaceID  = shipTo.getAttribute("personPlaceID");
				Element personPlace = (Element)eElement.getElementsByTagName("personPlace").item(0);
				
				ShopHqOrder order = new ShopHqOrder();
				if(!personPlace.getAttribute("personPlaceID").equals(shipToPersonPlaceID)){
					personPlace = (Element)eElement.getElementsByTagName("personPlace").item(1);
				}
				
				order.setPersonName(personPlace.getElementsByTagName("name1").item(0).getTextContent());
				order.setAddress(personPlace.getElementsByTagName("address1").item(0).getTextContent());
				if(personPlace.getElementsByTagName("address2").item(0) != null)
					order.setAddress2(personPlace.getElementsByTagName("address2").item(0).getTextContent());
				order.setCity(personPlace.getElementsByTagName("city").item(0).getTextContent());
				order.setState(personPlace.getElementsByTagName("state").item(0).getTextContent());
				order.setCountry(personPlace.getElementsByTagName("country").item(0).getTextContent());
				order.setZip(personPlace.getElementsByTagName("postalCode").item(0).getTextContent());
				order.setPhone(personPlace.getElementsByTagName("dayPhone").item(0).getTextContent());
				
				order.setShippingCode(eElement.getElementsByTagName("shippingCode").item(0).getTextContent());
				
				order.setCustomOrderNumber(eElement.getElementsByTagName("custOrderNumber").item(0).getTextContent());
				order.setQtyOrdered(Integer.parseInt(eElement.getElementsByTagName("qtyOrdered").item(0).getTextContent()));
				order.setMerchantLineNumber(eElement.getElementsByTagName("merchantLineNumber").item(0).getTextContent());
				order.setMerchantSku(eElement.getElementsByTagName("merchantSKU").item(0).getTextContent());
				order.setTrxDate(eElement.getElementsByTagName("orderDate").item(0).getTextContent());
				order.setTrxId(eElement.getElementsByTagName("orderId").item(0).getTextContent());
				order.setPoNumber(eElement.getElementsByTagName("poNumber").item(0).getTextContent());

				order.setUnitCost(Double.parseDouble(eElement.getElementsByTagName("unitCost").item(0).getTextContent()));
				order.setVendorSku(eElement.getElementsByTagName("vendorSKU").item(0).getTextContent());
				
				rtn.add(order);
			}
		}
		return rtn;
		
	}
	
	private String makePackageReference1(ShopHqOrder order){
		return "Order# "+order.getCustomOrderNumber();
	}
	private String makePackageReference2(ShopHqOrder order){
		return "PO# "+order.getPoNumber()+", "+order.getQtyOrdered()+"pcs "+order.getVendorSku();
	}
	
	private Document writeSingleConfirm(Document doc, Element rootElement, ShopHqOrder order, UpsShippingCsv ups, int count){
		Element hubConfirm = doc.createElement("hubConfirm");
		rootElement.appendChild(hubConfirm);
		
		//participatingParty elements
		Element participatingParty = doc.createElement("participatingParty");
		hubConfirm.appendChild(participatingParty);
		participatingParty.setAttribute("name", "shopHQ");
		participatingParty.setAttribute("participationCode", "To:");
		participatingParty.setAttribute("roleType", "merchant");
		participatingParty.appendChild(doc.createTextNode("snbc"));
		
		//partnerTrxID elements
		Element partnerTrxID = doc.createElement("partnerTrxID");
		partnerTrxID.appendChild(doc.createTextNode(order.getTrxId()));
		hubConfirm.appendChild(partnerTrxID);
		
		//partnerTrxDate elements
		Element partnerTrxDate = doc.createElement("partnerTrxDate");
		partnerTrxDate.appendChild(doc.createTextNode(order.getTrxDate()));
		hubConfirm.appendChild(partnerTrxDate);
		
		//poNumber elements
		Element poNumber = doc.createElement("poNumber");
		poNumber.appendChild(doc.createTextNode(order.getPoNumber()));
		hubConfirm.appendChild(poNumber);
		
		//hubAction elements
		Element hubAction = doc.createElement("hubAction");
		hubConfirm.appendChild(hubAction);
		
		//action elements
		Element action = doc.createElement("action");
		action.appendChild(doc.createTextNode("v_ship"));
		hubAction.appendChild(action);
		
		//merchantLineNumber elements
		Element merchantLineNumber  = doc.createElement("merchantLineNumber");
		merchantLineNumber.appendChild(doc.createTextNode(order.getMerchantLineNumber()));
		hubAction.appendChild(merchantLineNumber);
		
		//trxVendorSKU elements
		Element trxVendorSKU = doc.createElement("trxVendorSKU");
		trxVendorSKU.appendChild(doc.createTextNode(order.getVendorSku()));
		hubAction.appendChild(trxVendorSKU);
		
		//trxMerchantSKU elements
		Element trxMerchantSKU = doc.createElement("trxMerchantSKU");
		trxMerchantSKU.appendChild(doc.createTextNode(order.getMerchantSku()));
		hubAction.appendChild(trxMerchantSKU);
		
		//trxQty elements
		Element trxQty = doc.createElement("trxQty");
		trxQty.appendChild(doc.createTextNode(order.getQtyOrdered().toString()));
		hubAction.appendChild(trxQty);
		
		String packageDetailID = String.format("%03d", count);
		
		//packageDetailLink elements
		Element packageDetailLink = doc.createElement("packageDetailLink");
		packageDetailLink.setAttribute("packageDetailID", "P_"+packageDetailID);
		hubAction.appendChild(packageDetailLink);
		
		//packageDetail elements
		Element packageDetail = doc.createElement("packageDetail");
		packageDetail.setAttribute("packageDetailID", "P_"+packageDetailID);
		hubConfirm.appendChild(packageDetail);
		
		//shipDate elements
		Element shipDate = doc.createElement("shipDate");
		shipDate.appendChild(doc.createTextNode(this.getToday()));//TODO: see if can get the shipment date from ups shipment export
		packageDetail.appendChild(shipDate);
		
		//serviceLevel1 elements
		Element serviceLevel1 = doc.createElement("serviceLevel1");
		switch (order.getShippingCode()){
			case "UNSP_CG": case "UPSN_CG": case "UG": case "UPSG":  	
				serviceLevel1.appendChild(doc.createTextNode("UPSN_CG"));
				break;
			case "UPSN_SE": case "UB": case "UPSN_SC":
				serviceLevel1.appendChild(doc.createTextNode("UPSN_SC"));
				break;
			case "UPSN_3D": case "UPS3":
				serviceLevel1.appendChild(doc.createTextNode("UPSN_3D"));
				break;
			case "UPSET_ND": case "UZ": 
				serviceLevel1.appendChild(doc.createTextNode("UPSN_ND"));
				break;
			default:
				serviceLevel1.appendChild(doc.createTextNode("UPSN_CG"));
				break;	
		}
//		serviceLevel1.appendChild(doc.createTextNode("UPSN_CG"));
		packageDetail.appendChild(serviceLevel1);
		
		//trackingNumber elements
		Element trackingNumber = doc.createElement("trackingNumber");
		trackingNumber.appendChild(doc.createTextNode(ups.getPackageTrackingNumber()));
		packageDetail.appendChild(trackingNumber);
		
		return doc;
	}
	
	public String getToday(){
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyyMMdd").format(date);
		return modifiedDate;
	}
	
	public void readOrderAndGenerateShipmentXml(String orderFilePath, String upsShipmentFilePath){
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// create root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("ConfirmMessageBatch");
			doc.appendChild(rootElement);
	 
			Element partner= doc.createElement("partnerID");
			rootElement.appendChild(partner);
			partner.setAttribute("name", "RSPA, Inc. (Sungale)");
			partner.setAttribute("roleType", "vendor");
			partner.appendChild(doc.createTextNode("rspainc"));
	 
			List<ShopHqOrder> orders = this.getOrderList(orderFilePath);
			int count = 1;
			for(ShopHqOrder order: orders){
				UpsShippingCsv ups = this.findUpsShipping(order, upsShipmentFilePath); 
//System.out.println(ups);
				
				doc = this.writeSingleConfirm(doc, rootElement, order, ups, count);
				count++;
			}
			
			// finish root elements
			Element messageCount = doc.createElement("messageCount");
			messageCount.appendChild(doc.createTextNode(""+orders.size()));		
			rootElement.appendChild(messageCount);
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(outputPath+this.getOrderFileName(orderFilePath)+"_shipment.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("Shipment Xml saved::"+outputPath+this.getOrderFileName(orderFilePath)+"_shipment.xml");
	 
		  } catch (Exception pce) {
			pce.printStackTrace();
		  } 
	}
	
	public void readOrderAndGenerateUpsShippingImportCsv(String orderFilePath) {
		 try {
			 
				List<UpsCsv> list = new ArrayList<UpsCsv>();
				
				for(ShopHqOrder order: this.getOrderList(orderFilePath)){
						UpsCsv ups = new UpsCsv();
						ups.setShipTo_CompanyOrName(order.getPersonName());
						ups.setShipTo_StreetAddress(order.getAddress());
						ups.setShipTo_RoomFloorAddress2(order.getAddress2());
						ups.setShipTo_City(order.getCity());
						ups.setShipTo_State(order.getState());
						ups.setShipTo_Country(order.getCountry());
						ups.setShipTo_ZipCode(order.getZip());
						ups.setShipTo_Telephone(order.getPhone());
						ups.setPackage_Reference1(this.makePackageReference1(order));
						ups.setPackage_Reference2(this.makePackageReference2(order));
						//Constants
						ups.setPackage_PackageType("Package");
						switch(order.getShippingCode()){
							case "UNSP_CG": case "UPSN_CG": case "UG": case "UPSG":  	
								ups.setShipmentInformation_ServiceType("Ground");
								break;
							case "UPSN_SE": case "UB": case "UPSN_SC":
								ups.setShipmentInformation_ServiceType("UPS 2nd Day Air");
								break;
							case "UPSN_3D": case "UPS3":
								ups.setShipmentInformation_ServiceType("UPS 3 Day Select");
								break;
							case "UPSET_ND": case "UZ": 
								ups.setShipmentInformation_ServiceType("UPS Next Day Air, Signature Required");
								break;
							default:
								ups.setShipmentInformation_ServiceType("Ground");
								break;
						}
						ups.setShipTo_ResidentialIndicator("y");
						
						//set thirdparty shipping details
						ups.setShipmentInformation_BillingOption("TP");
						ups.setThirdParty_CompanyOrName("RSPA, INC.(ShopHQ fulfillment)");
						ups.setThirdParty_Address("13941 CENTRAL AVE");
						ups.setThirdParty_Country("United States");
						ups.setThirdParty_PostalCode("91710");
						ups.setThirdParty_City("Chino");
						ups.setThirdParty_State("CA");
						ups.setThirdParty_Telephone("9099021807");
						ups.setThirdParty_UPSAccount("W73528");
						
						
						list.add(ups);
						
					}
					
				WriteUpsCsv writer = new WriteUpsCsv();
				String fileName = this.getOrderFileName(orderFilePath);
				fileName = this.outputPath+fileName+"_ups.csv";				
				writer.writeWithCsvBeanWriter(list, fileName);
System.out.println("Generated ups csv at: "+fileName);				
		 } catch (Exception e) {
			 	e.printStackTrace();
		}
	}
	
	private String getOrderFileName(String orderFilePath){
		if(orderFilePath.endsWith(".xml"))
		return orderFilePath.substring(orderFilePath.lastIndexOf(System.getProperty("file.separator")), orderFilePath.lastIndexOf(".xml"));
		else
			return orderFilePath.substring(orderFilePath.lastIndexOf(System.getProperty("file.separator")));
	}
	
	public void readBatchOrderAndGenerateSingleUpsShippingCsv(String csvPath){
		try {
			
			List<UpsCsv> list = new ArrayList<UpsCsv>();
			
			File folder = new File(csvPath);
			File[] listOfFiles = folder.listFiles();
			for(File file:listOfFiles){
				String orderFilePath = file.getAbsolutePath();
				if(orderFilePath.endsWith(".neworders"))
				for(ShopHqOrder order: this.getOrderList(orderFilePath)){
					UpsCsv ups = new UpsCsv();
					ups.setShipTo_CompanyOrName(order.getPersonName());
					ups.setShipTo_StreetAddress(order.getAddress());
					ups.setShipTo_RoomFloorAddress2(order.getAddress2());
					ups.setShipTo_City(order.getCity());
					ups.setShipTo_State(order.getState());
					ups.setShipTo_Country(order.getCountry());
					ups.setShipTo_ZipCode(order.getZip());
					ups.setShipTo_Telephone(order.getPhone());
					ups.setPackage_Reference1(this.makePackageReference1(order));
					ups.setPackage_Reference2(this.makePackageReference2(order));
					//Constants
					ups.setPackage_PackageType("Package");
					switch(order.getShippingCode()){
					case "UNSP_CG": case "UPSN_CG": case "UG": case "UPSG":  	
						ups.setShipmentInformation_ServiceType("Ground");
						break;
					case "UPSN_SE": case "UB": case "UPSN_SC":
						ups.setShipmentInformation_ServiceType("UPS 2nd Day Air");
						break;
					case "UPSN_3D": case "UPS3":
						ups.setShipmentInformation_ServiceType("UPS 3 Day Select");
						break;
					case "UPSET_ND": case "UZ": 
						ups.setShipmentInformation_ServiceType("UPS Next Day Air, Signature Required");
						break;
					default:
						ups.setShipmentInformation_ServiceType("Ground");
						break;
					}
					ups.setShipTo_ResidentialIndicator("y");
					
					//set thirdparty shipping details
					ups.setShipmentInformation_BillingOption("TP");
					ups.setThirdParty_CompanyOrName("RSPA, INC.(ShopHQ fulfillment)");
					ups.setThirdParty_Address("13941 CENTRAL AVE");
					ups.setThirdParty_Country("United States");
					ups.setThirdParty_PostalCode("91710");
					ups.setThirdParty_City("Chino");
					ups.setThirdParty_State("CA");
					ups.setThirdParty_Telephone("9099021807");
					ups.setThirdParty_UPSAccount("W73528");
					
					
					list.add(ups);
					
				}
			}
			
			
				
			WriteUpsCsv writer = new WriteUpsCsv();
			String fileName = this.outputPath+"\\order_combined_ups.csv";				
			writer.writeWithCsvBeanWriter(list, fileName);
System.out.println("Generated ups csv at: "+fileName);				
	 } catch (Exception e) {
		 	e.printStackTrace();
	}
	}

	public static void main(String argv[]) throws Exception {
		ProcessShopHq obj = new ProcessShopHq("C:\\drop-ship\\shopHQ\\20141119");
		
		String folderPath = "C:\\drop-ship\\shopHQ\\20141119\\";
//		obj.readOrderAndGenerateUpsShippingImportCsv(folderPath);
//		obj.readBatchOrderAndGenerateSingleUpsShippingCsv(folderPath);
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();
		String upsShipmentFilePath = "C:\\drop-ship\\shopHQ\\20141119\\UPS_CSV_EXPORT_20141119.csv";
//		obj.readOrderAndGenerateInvoiceXml(folderPath, upsShipmentFilePath);
//		obj.readOrderAndGenerateShipmentXml(folderPath, upsShipmentFilePath);
		for(File file: listOfFiles){
			System.out.println("processing "+file.getAbsolutePath());
			String orderFilePath = file.getAbsolutePath();
			if(!orderFilePath.endsWith(".neworders"))
				continue;
			obj.readOrderAndGenerateShipmentXml(orderFilePath, upsShipmentFilePath);
			obj.readOrderAndGenerateInvoiceXml(orderFilePath, upsShipmentFilePath);
		}
	  }
	 
}
