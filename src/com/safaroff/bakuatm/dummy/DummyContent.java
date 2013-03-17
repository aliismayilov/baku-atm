package com.safaroff.bakuatm.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.android.gms.maps.model.LatLng;
import com.safaroff.bakuatm.models.ATM;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<ATM> ITEMS = new ArrayList<ATM>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, ATM> ITEM_MAP = new HashMap<String, ATM>();

	static {
		// Add 3 sample items.
		addItem(new ATM("\"Yamaha\" mağazası", "H.Cavid pr. 528 məh", null, new LatLng(40.397157, 49.82583)));
		addItem(new ATM("H.Cavid Filialı 1", "Bakı, Yasamal rayonu, ...", null, new LatLng(40.497157, 49.92583)));
		addItem(new ATM("Prospekt", "H.Cavid pr. ev 15, Space TV ilə ...", null, new LatLng(40.597157, 50.02583)));
	}

	private static void addItem(ATM item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.shortAddress, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	/*public static class DummyItem {
		public String id;
		public String content;

		public DummyItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}*/
}
