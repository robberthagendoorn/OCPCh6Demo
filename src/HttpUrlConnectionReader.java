import java.io.*;
import java.net.*;

public class HttpUrlConnectionReader {

	public HttpUrlConnectionReader() {
	}

	public String connect(String targetUrl) throws IOException {
		try {
			URL url = new URL(targetUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setReadTimeout(250);
			connection.connect();
			return readOutput(connection);
		} catch (IOException e) {
			throw e;
		}
	}	
	
	private static String readOutput(HttpURLConnection connection) throws IOException {
		try	(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			StringBuilder output = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null)	{
				output.append(line+ "\n");
			}
			return output.toString();
		} catch (IOException e) {
			throw e;
		}
	}	
}	
