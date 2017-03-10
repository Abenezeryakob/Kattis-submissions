from Labb6k1 import Q
from sys import stdin

class Grammatikfel(Exception):
    pass

def readFormel(formelq):
    checkq =(formelq.peek())
    if not formelq.isEmpty(): #undersök om kön är tom
        readMol(formelq)# börja läsa mol
        if not formelq.isEmpty():
            raise Grammatikfel("Felaktig gruppstart vid radslutet")
        
    else:
        raise Grammatikfel("Felaktig gruppstart vid radslutet")
def readMol(formelq):
    checkq =(formelq.peek())

    readGroup(formelq)# börja med att undersöka grupper
    if not formelq.isEmpty() and formelq.peek()!=")":#undersök om gruppen avslutades
        readMol(formelq)
    

def readGroup(formelq):
    checkq =(formelq.peek())
    bigLetter = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
    
    if not formelq.isEmpty() and formelq.peek().isupper(): # undersök om det börjar med storbokstav
        readAtom(formelq)
        if not formelq.isEmpty()and formelq.peek().isdigit():# Kollar om det kommer en siffra efter atomen
            readNum(formelq)
    elif formelq.peek()=="(": #undersök om det börjar med parantes
        
        formelq.get() # ta ut parantesn från kön
        readMol(formelq)# undersökmolen efter parantesen
        if not formelq.isEmpty()and formelq.peek()==")":
            formelq.get() #tabort slutparantesen från kön
        else :
            raise Grammatikfel ("Saknad högerparentes vid radslutet")
        if not formelq.isEmpty() and formelq.peek().isdigit(): # om parantesen har avslutat rätt måste vi kolla efter nummer
            readNum(formelq)
        else :
            raise Grammatikfel("Saknad siffra vid radslutet")
    else:# om inte storbokstav eller startparantes
        if formelq.peek()==")" or formelq.peek().isdigit():
            
            raise Grammatikfel("Felaktig gruppstart vid radslutet")
        elif formelq.peek().islower():
            raise Grammatikfel("Saknad stor bokstav vid radslutet")
        else:
            raise Grammatikfel("Okänd atom vid radslutet")

        
def readAtom (formelq):
    checkq =(formelq.peek())
    
    
    element=["H","He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "Fe"]
    #bigLetter = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
    #smallLetter = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    if formelq.peek().isupper(): #om atomen börjar med storbokstav
        bigl = formelq.get()
        
        if not formelq.isEmpty() and formelq.peek().islower(): # om parantesen har avslutat rätt måste vi kolla efter nummer
            small = formelq.get()
        else:
            small=""
        biglsmall =str( bigl) + str(small )# sätt ihop stor och liten bokstav
        if not biglsmall in element:
            raise Grammatikfel("Okänd atom vid radslutet")
    else:# om inte storbokstav
        if formelq.get().islower():#om det är littetbokstav
            raise Grammatikfel("Saknad stor bokstav vid radslutet")
        else: # om det är något annat än storbokstav/littetbokstav
            raise Grammatikfel("Felaktig gruppstart vid radslutet")




def readNum(formelq):
    checkq =(formelq.peek())
    if not formelq.isEmpty() and formelq.peek()=="0": #om 0 längst upp ikön
        formelq.get()
        raise Grammatikfel("För litet tal vid radslutet")
    number=""
    while not formelq.isEmpty() and formelq.peek().isdigit():
        
        number += formelq.get()
        if not formelq.isEmpty():
            formelq.peek
            
    if int(number) <2:# om mindre än 2
        raise Grammatikfel("För litet tal vid radslutet")
    

def checkq(formel):
    if formel=='#':
        raise SystemExit



def main():
    informel = stdin.readline()
    
    
    while informel:
        informel = list(informel.strip('\n'))
        
        formelq = Q()
        for i in informel:
            formelq.put(i)
            
     
        try:
            
            checkq(formelq.peek())# kolla om kö är tom för att avsluta
            readFormel(formelq)# börja med att kolla formeln
            
             
            print("Formeln är syntaktiskt korrekt")
            
                #main()
             
        except Grammatikfel as fel:
            rest =""
            while not formelq.isEmpty():
                rest +=formelq.get()
             
            print(fel, rest)
        informel = stdin.readline()

   
         
         
     
main()