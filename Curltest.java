import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;


public class curlTest {

	public static void main(String[] args) {

		String stringUrl = "https://api.qatouch.com/api/v1/getAllProjects";
		URL url;
		try {
			url = new URL(stringUrl);
			URLConnection uc;
			uc = url.openConnection();
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			//uc.setRequestProperty("X-Requested-With", "Curl");
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type","application/json");
			conn.setDoOutput(true);
			conn.setRequestProperty("domain", "malar");
			conn.setRequestProperty("api-token", "73d8e663e9750d3a5410c8e2a113220f5ae88c203a2a9847b23e40c4c075feae");

						
			int responseCode = conn.getResponseCode();
			System.out.println("Response Code : " + responseCode);

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				//builder.append(System.getProperty("line.separator"));

			}
			reader.close();
			String result = builder.toString();
			System.out.println(result);
			
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(result);
				
				System.out.println(jsonObject.toString(4));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// To string method prints it with specified indentation
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
