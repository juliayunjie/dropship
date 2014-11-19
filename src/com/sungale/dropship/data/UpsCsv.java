/**
 * 
 */
package com.sungale.dropship.data;

/**
 * @author Julia Sun
 *the form to be imported to UPS system
 */
public class UpsCsv {
	private String OrderId;
	private String ShipmentInformation_ServiceType;
	private String ShipmentInformation_BillingOption;
	private String ShipmentInformation_QvnOption;
	private String ShipmentInformation_QvnShipNotification1Option;
	private String ShipmentInformation_NotificationRecipient1Type;
	private String ShipmentInformation_NotificationRecipient1FaxorEmail;
	private String ShipTo_CompanyOrName;
	private String ShipTo_StreetAddress;
	private String ShipTo_RoomFloorAddress2;
	private String ShipTo_City;
	private String ShipTo_State;
	private String ShipTo_Country;
	private String ShipTo_ZipCode;
	private String ShipTo_Telephone;
	private String ShipTo_ResidentialIndicator;
	
	private String ThirdParty_CompanyOrName;
	private String ThirdParty_Attention;
	private String ThirdParty_Address;
	private String ThirdParty_Address2;
	private String ThirdParty_Country;
	private String ThirdParty_PostalCode;
	private String ThirdParty_City;
	private String ThirdParty_State;
	private String ThirdParty_Telephone;
	private String ThirdParty_UPSAccount;
	
	private String Package_PackageType;
	private Double Package_Weight;
	private String Package_Reference1;
	private String Package_Reference2;
	private String Package_Reference3;
	private String Package_Reference4;
	private String Package_Reference5;
	private String Package_DeclaredValueOption;
	private Double Package_DeclaredValueAmount;
	private String ShipTo_LocationID;

	public UpsCsv(){
		
	}

	

	public UpsCsv(String orderId, String shipmentInformation_ServiceType,
			String shipmentInformation_BillingOption,
			String shipmentInformation_QvnOption,
			String shipmentInformation_QvnShipNotification1Option,
			String shipmentInformation_NotificationRecipient1Type,
			String shipmentInformation_NotificationRecipient1FaxorEmail,
			String shipTo_CompanyOrName, String shipTo_StreetAddress,
			String shipTo_RoomFloorAddress2, String shipTo_City,
			String shipTo_State, String shipTo_Country, String shipTo_ZipCode,
			String shipTo_Telephone, String shipTo_ResidentialIndicator,
			String thirdParty_CompanyOrName, String thirdParty_Attention,
			String thirdParty_Address, String thirdParty_Address2,
			String thirdParty_Country, String thirdParty_PostalCode,
			String thirdParty_City, String thirdParty_State,
			String thirdParty_Telephone, String thirdParty_UPSAccount,
			String package_PackageType, Double package_Weight,
			String package_Reference1, String package_Reference2,
			String package_Reference3, String package_Reference4,
			String package_Reference5, String package_DeclaredValueOption,
			Double package_DeclaredValueAmount, String shipTo_LocationID) {
		super();
		OrderId = orderId;
		ShipmentInformation_ServiceType = shipmentInformation_ServiceType;
		ShipmentInformation_BillingOption = shipmentInformation_BillingOption;
		ShipmentInformation_QvnOption = shipmentInformation_QvnOption;
		ShipmentInformation_QvnShipNotification1Option = shipmentInformation_QvnShipNotification1Option;
		ShipmentInformation_NotificationRecipient1Type = shipmentInformation_NotificationRecipient1Type;
		ShipmentInformation_NotificationRecipient1FaxorEmail = shipmentInformation_NotificationRecipient1FaxorEmail;
		ShipTo_CompanyOrName = shipTo_CompanyOrName;
		ShipTo_StreetAddress = shipTo_StreetAddress;
		ShipTo_RoomFloorAddress2 = shipTo_RoomFloorAddress2;
		ShipTo_City = shipTo_City;
		ShipTo_State = shipTo_State;
		ShipTo_Country = shipTo_Country;
		ShipTo_ZipCode = shipTo_ZipCode;
		ShipTo_Telephone = shipTo_Telephone;
		ShipTo_ResidentialIndicator = shipTo_ResidentialIndicator;
		ThirdParty_CompanyOrName = thirdParty_CompanyOrName;
		ThirdParty_Attention = thirdParty_Attention;
		ThirdParty_Address = thirdParty_Address;
		ThirdParty_Address2 = thirdParty_Address2;
		ThirdParty_Country = thirdParty_Country;
		ThirdParty_PostalCode = thirdParty_PostalCode;
		ThirdParty_City = thirdParty_City;
		ThirdParty_State = thirdParty_State;
		ThirdParty_Telephone = thirdParty_Telephone;
		ThirdParty_UPSAccount = thirdParty_UPSAccount;
		Package_PackageType = package_PackageType;
		Package_Weight = package_Weight;
		Package_Reference1 = package_Reference1;
		Package_Reference2 = package_Reference2;
		Package_Reference3 = package_Reference3;
		Package_Reference4 = package_Reference4;
		Package_Reference5 = package_Reference5;
		Package_DeclaredValueOption = package_DeclaredValueOption;
		Package_DeclaredValueAmount = package_DeclaredValueAmount;
		ShipTo_LocationID = shipTo_LocationID;
	}



	@Override
	public String toString() {
		return "UpsCsv [OrderId=" + OrderId
				+ ", ShipmentInformation_ServiceType="
				+ ShipmentInformation_ServiceType
				+ ", ShipmentInformation_BillingOption="
				+ ShipmentInformation_BillingOption
				+ ", ShipmentInformation_QvnOption="
				+ ShipmentInformation_QvnOption
				+ ", ShipmentInformation_QvnShipNotification1Option="
				+ ShipmentInformation_QvnShipNotification1Option
				+ ", ShipmentInformation_NotificationRecipientType="
				+ ShipmentInformation_NotificationRecipient1Type
				+ ", ShipmentInformation_NotificationRecipient1FaxorEmail="
				+ ShipmentInformation_NotificationRecipient1FaxorEmail
				+ ", ShipTo_CompanyOrName=" + ShipTo_CompanyOrName
				+ ", ShipTo_StreetAddress=" + ShipTo_StreetAddress
				+ ", ShipTo_RoomFloorAddress2=" + ShipTo_RoomFloorAddress2
				+ ", ShipTo_City=" + ShipTo_City + ", ShipTo_State="
				+ ShipTo_State + ", ShipTo_Country=" + ShipTo_Country
				+ ", ShipTo_ZipCode=" + ShipTo_ZipCode + ", ShipTo_Telephone="
				+ ShipTo_Telephone + ", ShipTo_ResidentialIndicator="
				+ ShipTo_ResidentialIndicator + ", Package_PackageType="
				+ Package_PackageType + ", Package_Weight=" + Package_Weight
				+ ", Package_Reference1=" + Package_Reference1
				+ ", Package_Reference2=" + Package_Reference2
				+ ", Package_Reference3=" + Package_Reference3
				+ ", Package_Reference4=" + Package_Reference4
				+ ", Package_Reference5=" + Package_Reference5
				+ ", Package_DeclaredValueOption="
				+ Package_DeclaredValueOption
				+ ", Package_DeclaredValueAmount="
				+ Package_DeclaredValueAmount + ", ShipTo_LocationID="
				+ ShipTo_LocationID + "]";
	}

	
	
	public String getThirdParty_CompanyOrName() {
		return ThirdParty_CompanyOrName;
	}



	public void setThirdParty_CompanyOrName(String thirdParty_CompanyOrName) {
		ThirdParty_CompanyOrName = thirdParty_CompanyOrName;
	}



	public String getThirdParty_Attention() {
		return ThirdParty_Attention;
	}



	public void setThirdParty_Attention(String thirdParty_Attention) {
		ThirdParty_Attention = thirdParty_Attention;
	}



	public String getThirdParty_Address() {
		return ThirdParty_Address;
	}



	public void setThirdParty_Address(String thirdParty_Address) {
		ThirdParty_Address = thirdParty_Address;
	}



	public String getThirdParty_Address2() {
		return ThirdParty_Address2;
	}



	public void setThirdParty_Address2(String thirdParty_Address2) {
		ThirdParty_Address2 = thirdParty_Address2;
	}



	public String getThirdParty_Country() {
		return ThirdParty_Country;
	}



	public void setThirdParty_Country(String thirdParty_Country) {
		ThirdParty_Country = thirdParty_Country;
	}



	public String getThirdParty_PostalCode() {
		return ThirdParty_PostalCode;
	}



	public void setThirdParty_PostalCode(String thirdParty_PostalCode) {
		ThirdParty_PostalCode = thirdParty_PostalCode;
	}



	public String getThirdParty_City() {
		return ThirdParty_City;
	}



	public void setThirdParty_City(String thirdParty_City) {
		ThirdParty_City = thirdParty_City;
	}



	public String getThirdParty_State() {
		return ThirdParty_State;
	}



	public void setThirdParty_State(String thirdParty_State) {
		ThirdParty_State = thirdParty_State;
	}



	public String getThirdParty_Telephone() {
		return ThirdParty_Telephone;
	}



	public void setThirdParty_Telephone(String thirdParty_Telephone) {
		ThirdParty_Telephone = thirdParty_Telephone;
	}



	public String getThirdParty_UPSAccount() {
		return ThirdParty_UPSAccount;
	}



	public void setThirdParty_UPSAccount(String thirdParty_UPSAccount) {
		ThirdParty_UPSAccount = thirdParty_UPSAccount;
	}



	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public String getShipmentInformation_ServiceType() {
		return ShipmentInformation_ServiceType;
	}

	public void setShipmentInformation_ServiceType(
			String shipmentInformation_ServiceType) {
		ShipmentInformation_ServiceType = shipmentInformation_ServiceType;
	}

	public String getShipmentInformation_BillingOption() {
		return ShipmentInformation_BillingOption;
	}

	public void setShipmentInformation_BillingOption(
			String shipmentInformation_BillingOption) {
		ShipmentInformation_BillingOption = shipmentInformation_BillingOption;
	}

	public String getShipmentInformation_QvnOption() {
		return ShipmentInformation_QvnOption;
	}

	public void setShipmentInformation_QvnOption(
			String shipmentInformation_QvnOption) {
		ShipmentInformation_QvnOption = shipmentInformation_QvnOption;
	}

	public String getShipmentInformation_QvnShipNotification1Option() {
		return ShipmentInformation_QvnShipNotification1Option;
	}

	public void setShipmentInformation_QvnShipNotification1Option(
			String shipmentInformation_QvnShipNotification1Option) {
		ShipmentInformation_QvnShipNotification1Option = shipmentInformation_QvnShipNotification1Option;
	}

	public String getShipmentInformation_NotificationRecipient1Type() {
		return ShipmentInformation_NotificationRecipient1Type;
	}

	public void setShipmentInformation_NotificationRecipient1Type(
			String shipmentInformation_NotificationRecipient1Type) {
		ShipmentInformation_NotificationRecipient1Type = shipmentInformation_NotificationRecipient1Type;
	}

	public String getShipmentInformation_NotificationRecipient1FaxorEmail() {
		return ShipmentInformation_NotificationRecipient1FaxorEmail;
	}

	public void setShipmentInformation_NotificationRecipient1FaxorEmail(
			String shipmentInformation_NotificationRecipient1FaxorEmail) {
		ShipmentInformation_NotificationRecipient1FaxorEmail = shipmentInformation_NotificationRecipient1FaxorEmail;
	}

	public String getShipTo_CompanyOrName() {
		return ShipTo_CompanyOrName;
	}

	public void setShipTo_CompanyOrName(String shipTo_CompanyOrName) {
		ShipTo_CompanyOrName = shipTo_CompanyOrName;
	}

	public String getShipTo_StreetAddress() {
		return ShipTo_StreetAddress;
	}

	public void setShipTo_StreetAddress(String shipTo_StreetAddress) {
		ShipTo_StreetAddress = shipTo_StreetAddress;
	}

	public String getShipTo_RoomFloorAddress2() {
		return ShipTo_RoomFloorAddress2;
	}

	public void setShipTo_RoomFloorAddress2(String shipTo_RoomFloorAddress2) {
		ShipTo_RoomFloorAddress2 = shipTo_RoomFloorAddress2;
	}

	public String getShipTo_City() {
		return ShipTo_City;
	}

	public void setShipTo_City(String shipTo_City) {
		ShipTo_City = shipTo_City;
	}

	public String getShipTo_State() {
		return ShipTo_State;
	}

	public void setShipTo_State(String shipTo_State) {
		ShipTo_State = shipTo_State;
	}

	public String getShipTo_Country() {
		return ShipTo_Country;
	}

	public void setShipTo_Country(String shipTo_Country) {
		ShipTo_Country = shipTo_Country;
	}

	public String getShipTo_ZipCode() {
		return ShipTo_ZipCode;
	}

	public void setShipTo_ZipCode(String shipTo_ZipCode) {
		ShipTo_ZipCode = shipTo_ZipCode;
	}

	public String getShipTo_Telephone() {
		return ShipTo_Telephone;
	}

	public void setShipTo_Telephone(String shipTo_Telephone) {
		ShipTo_Telephone = shipTo_Telephone;
	}

	public String getShipTo_ResidentialIndicator() {
		return ShipTo_ResidentialIndicator;
	}

	public void setShipTo_ResidentialIndicator(String shipTo_ResidentialIndicator) {
		ShipTo_ResidentialIndicator = shipTo_ResidentialIndicator;
	}

	public String getPackage_PackageType() {
		return Package_PackageType;
	}

	public void setPackage_PackageType(String package_PackageType) {
		Package_PackageType = package_PackageType;
	}

	public Double getPackage_Weight() {
		return Package_Weight;
	}

	public void setPackage_Weight(Double package_Weight) {
		Package_Weight = package_Weight;
	}

	public String getPackage_Reference1() {
		return Package_Reference1;
	}

	public void setPackage_Reference1(String package_Reference1) {
		Package_Reference1 = package_Reference1;
	}

	public String getPackage_Reference2() {
		return Package_Reference2;
	}

	public void setPackage_Reference2(String package_Reference2) {
		Package_Reference2 = package_Reference2;
	}

	public String getPackage_Reference3() {
		return Package_Reference3;
	}

	public void setPackage_Reference3(String package_Reference3) {
		Package_Reference3 = package_Reference3;
	}

	public String getPackage_Reference4() {
		return Package_Reference4;
	}

	public void setPackage_Reference4(String package_Reference4) {
		Package_Reference4 = package_Reference4;
	}

	public String getPackage_Reference5() {
		return Package_Reference5;
	}

	public void setPackage_Reference5(String package_Reference5) {
		Package_Reference5 = package_Reference5;
	}

	public String getPackage_DeclaredValueOption() {
		return Package_DeclaredValueOption;
	}

	public void setPackage_DeclaredValueOption(String package_DeclaredValueOption) {
		Package_DeclaredValueOption = package_DeclaredValueOption;
	}

	public Double getPackage_DeclaredValueAmount() {
		return Package_DeclaredValueAmount;
	}

	public void setPackage_DeclaredValueAmount(Double package_DeclaredValueAmount) {
		Package_DeclaredValueAmount = package_DeclaredValueAmount;
	}

	public String getShipTo_LocationID() {
		return ShipTo_LocationID;
	}

	public void setShipTo_LocationID(String shipTo_LocationID) {
		ShipTo_LocationID = shipTo_LocationID;
	}
	
}
