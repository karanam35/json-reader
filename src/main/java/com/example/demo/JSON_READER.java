package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON_READER {
	public static void main(String[] args) {
		String jsonData = readFile("D://Java//correct_offer.json");
		JSONObject jobj = new JSONObject(jsonData);
		JSONObject logisticsOffer = jobj.getJSONObject("logisticsOffer");
		JSONArray additionalDerivationDetails = new JSONArray(
				jobj.getJSONArray("additionalDerivationDetails").toString());
		if (additionalDerivationDetails.length() > 0) {
			for (int i = 0; i < additionalDerivationDetails.length(); i++) {
				JSONObject payload = additionalDerivationDetails.getJSONObject(i).getJSONObject("payload");
				if (payload != null) {
					String eligibilityName = payload.getString("eligibilityName");
					System.out.println("payload: eligibility name : " + eligibilityName);
					String eligibilityValue = payload.getString("eligibilityValue");
					System.out.println("payload: eligibilityValue : " + eligibilityValue);
					Boolean productPackageDimensions = logisticsOffer.has("productPackageDimensions");
					if (eligibilityName.equalsIgnoreCase("PUT_Eligiblity") && eligibilityValue.equalsIgnoreCase("true")
							&& productPackageDimensions==false) {
						JSONObject logisticsOfferId = logisticsOffer.getJSONObject("logisticsOfferId");
						String offerId = logisticsOfferId.getString("offerId");
						System.out.println("offerId:" + offerId);
						String legacyItemId = logisticsOfferId.getString("legacyItemId");
						System.out.println("legacyItemId:" + legacyItemId);
						System.out.println("Conditon is satisfied");
					}
				}
			}
		}
	}

	public static String readFile(String filename) {
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}