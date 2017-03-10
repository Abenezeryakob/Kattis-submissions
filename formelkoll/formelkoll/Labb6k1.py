class Q:
    def __init__(self):        #Initierar attributen first och last
        self.first=None        #First och last pekar på none
        self.last=None

    def __str__(self):               #Returnerar köns element som en sträng
        s = ""
        p = self.first
        while p != None:             #Lägger till varje element i listan i strängen s
            s = s + " "+ str(p.value)
            p = p.next
        return s.strip()


    def put(self,x):                    #Lägger till kort-noderna i kön
        ny=Node(x)                      #Skapar nod-objekt
        if self.first==None:            #Om den länkade listan är tom
            self.first=ny               #First och last ska peka på samma nod
            self.last=ny
        else:                           #Om den länkade listan inte är tom
            self.last.next=ny           #Lägger till den längst bak
            self.last=ny

    def get(self):                           #tar bort kort-noder ur kön
        value=self.first.value               #sparar värdet i noden
        self.first=self.first.next           #peka om first till nästa nod
        return (value)

    def isEmpty(self):                   #Kollar om kön är tom. Den är tom om first pekar på none alltså den har ingen nod-svans
      if self.first == None: 
         return True
      else: 
         return False

    def peek(self): # Retunerar (utan att plocka ut) första värdet i kön
        return self.first.value

class Node:                         #Initierar attribuen value och next
    def __init__(self, x):
        self.value = x
        self.next = None

        
