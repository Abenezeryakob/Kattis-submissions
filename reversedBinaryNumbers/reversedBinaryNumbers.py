def main():
    decNummber = int(input (""))
    listOfBinery= list(bin (decNummber))
    for i  in listOfBinery:
        if i =='b':
            listOfBinery.remove('b')
            listOfBinery.remove('0')
            listOfBinery.reverse()           
    riversNummber =''.join(listOfBinery)
    print(int(riversNummber,2))
main()

