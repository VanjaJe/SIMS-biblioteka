package enums;

public enum TipKorisnika {
	SPECIJALNI_BIBLIOTEKAR {
		public String toString() {
			return "Specijalni bibliotekar";
		}
	},
	OBICNI_BIBLIOTEKAR {
		public String toString() {
			return "Obicni bibliotekar";
		}
	},
	CLAN {
		public String toString() {
			return "Clan";
		}
	},
	ADMIN {
		public String toString() {
			return "Admin";
		}
	}
}
