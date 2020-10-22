 public static void ShowUI(Account account) {
		Dialog dlg=null;
		Factory factory = new Factory();
                if(account instanceof SA) {
			dlg = factory.get((SA)account);
		}
		if(account instanceof CA) {
                        dlg = factory.get((CA)account);
		}
		if(dlg!=null) {
			dlg.Display();			
		}
	}
