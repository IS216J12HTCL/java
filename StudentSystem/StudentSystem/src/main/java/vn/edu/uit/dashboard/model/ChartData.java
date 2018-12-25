package vn.edu.uit.dashboard.model;

public class ChartData {

	public static class KeyValue {
		String key;
		int value;

		public KeyValue(String key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}
	
	public static class DateKeyValue{
		String date;
		String key;
		int value;
		
		
		public DateKeyValue() {
			super();
		}


		public DateKeyValue(String date, String key, int value) {
			super();
			this.date = date;
			this.key = key;
			this.value = value;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public String getKey() {
			return key;
		}


		public void setKey(String key) {
			this.key = key;
		}


		public int getValue() {
			return value;
		}


		public void setValue(int value) {
			this.value = value;
		}
	}

}
