import java.io.*;
import java.net.*;
import com.google.gson.*;


public class Coin_api {
	
	
	//url 요청을 통해 json String을 가져오는 함수
	public static String getStringFromUrl(String url) throws Throwable {
        HttpURLConnection huc = (HttpURLConnection) new URL(url).openConnection();
        huc.setRequestMethod("GET");
        huc.addRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        huc.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");     
        huc.connect();
        InputStream in = null;
        if( huc.getResponseCode() != 200 ){
            in = huc.getErrorStream();
        }else{
            in = huc.getInputStream();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(  in , "UTF-8"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
	
	
	public static void printTicker() throws Throwable {     
        String json_str = getStringFromUrl("https://api.binance.com/api/v1/ticker/24hr");
        Gson gson = new Gson();     
        JsonArray ja = gson.fromJson(json_str, JsonElement.class).getAsJsonArray();
        String[][] datas = new String[ja.size()][2];
        for(int i = 0; i < ja.size();i++){          
            JsonObject market = ja.get(i).getAsJsonObject();
            //System.out.println(market.get("symbol") + " : " + market);
            datas[i][0] = market.get("symbol").toString();
            datas[i][1] = market.get("lastPrice").toString();
            //System.out.println(market.get("symbol") + " : "+ market.get("lastPrice") );
        }
        
        
        for(int i = 0 ; i < datas.length ; i++) {
        	System.out.println("coin name : "+datas[i][0] + "    price : " + datas[i][1]);
        	
        }
    }
	
}
