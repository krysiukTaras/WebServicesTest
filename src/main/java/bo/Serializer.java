package bo;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Taras_Krysiuk
 */
public class Serializer {
    public<T> List<T> deserialize(String json, Class<? extends T> t) {
		List<T> response = new ArrayList<T>();
		response.add((T) new Gson().fromJson(json, t));
		return response;
	}
	
	public<T> String serialize(T object) {
		String json = new Gson().toJson(object);
		return json;
	}
}
