 public static void ShowUI(Account account) {
		Dialog dlg=null;
		Factory factory = new Factory();
    if(account instanceof SA) {
			dlg = factory.get((SADialog)account);
		}
		if(account instanceof CA) {
      dlg = factory.get((CADialog)account);
		}
		if(dlg!=null) {
			dlg.Display();			
		}
	}
