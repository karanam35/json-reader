package com.example.demo;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class PackageDimensions {
	
	public static void main(String[] args) {
		
		try {
			int count=0;
			String content = new String(Files.readAllBytes(Paths.get("D://Java//correct_offer.json")));
			JSONObject productJson = new JSONObject(content);
			JSONObject logisticsOffer = productJson.getJSONObject("logisticsOffer");
			JSONObject additionalDerivationDetails = productJson.getJSONObject("additionalDerivationDetails");

			JSONArray productPakDimen = logisticsOffer.getJSONArray("productPackageDimensions");
			
			
			

			try {
				
					if (productPakDimen != null) {

						//String pangaeaDistributorId = logisticsOffer.getJSONObject(i).getString("pangaeaDistributorId");
						count++;
						System.out.println("productPakDimen" + productPakDimen);
					}
			
				
			} catch (Exception e) {
				System.out.println("count"+count);
				JSONObject logisticsOfferId = logisticsOffer.getJSONObject("logisticsOfferId");
				String offerId = logisticsOfferId.getString("offerId");
				System.out.println("offerId" + offerId);
				String gtin = logisticsOfferId.getString("gtin");
				System.out.println("gtin" + gtin);
				// String offerId=currentDynamicValue.getJSONObject(i).getString("offerId");
				// TODO: handle exception
			}
			

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
