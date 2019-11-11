class StopWatch:
	
  def __init__(self):
    self.flag = 0
	
  def start(self):
    if self.flag != 0:
      return self.false
		
    #logic
    self.flag = 1
    return true
	
  def stop(self):
    if self.flag != 1 or self.flag!= 2 :
      return false
		
		#logic
    self.flag = 0
    return true
	
  def pause():
    if self.flag != 1:
      return self.false
		
		#logic
    self.flag = 2
    return true
	
  def resume(self):
    if self.flag != 2:
      return self.false
		
		#logic
    self.flag = 1
    return true
