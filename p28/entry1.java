class Dialog{
  TextBox t1;
  TextBox t2;
  TextBox t3;
  Button b1;
  
  b1_Onclick(){
     int i = int.parse(t1.getText());
     int j = int.parse(t2.getText());
     Math obj = new Math();
     int k = obj.add(10,20);
     t3.setText(k.toString());
  }
}
