class SurveyData:
    def __init__(self):
      self.path="" #save the data to this file.
      self.hidden=False #should the file be hidden?
    
    def setSavePath(self,t):
        if t == 0:
            #raw data.
            path = "c:/application/data/raw.dat"
            hidden = True;
        elif t == 1:
            #cleaned up data.
            path = "c:/application/data/cleanedUp.dat"
            hidden = True
        elif t == 2:
            #processed data.
            path = "c:/application/data/processed.dat"
            hidden = True
        elif t == 3:
            #data ready for publication.
            path = "c:/application/data/publication.dat"
            hidden = False
