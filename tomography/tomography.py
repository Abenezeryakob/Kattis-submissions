def test (row_sums, column_sums, metrx_size):

    if metrix_size[0] <= metrix_size[1]:
        for row_sum in row_sums:
            column_sums = sorted(column_sums, reverse=True)
            for j in range(row_sum):
                if column_sums[j] != 0:
                    column_sums[j] =column_sums[j] - 1
                    
                    #print(column_sums)
                elif column_sums[j] == 0:
                    lo  = True
                    z=j
                    try: 
                        while(lo):
                            if(column_sums[z] != 0):
                                column_sums[z] =column_sums[z] - 1
                                #print(column_sums)
       
                                lo =False
                            z=z+1
                    except:
                        return 'No'
        if sum(column_sums)==0:
            return "Yes"
        else:
            return 'No'

    if metrix_size[0] > metrix_size[1]:
        #print('här')
        for column_sum in column_sums:
            row_sums = sorted(row_sums, reverse=True)
            for j in range(column_sum):
                if row_sums[j] != 0:
                    row_sums[j] =row_sums[j] - 1
                    #print(row_sums)
                elif row_sums[j] == 0:
                    lo  = True
                    z=j
                    try: 
                        while(lo):
                            if(row_sums[z] != 0):
                                row_sums[z] =row_sums[z] - 1
                                #print(row_sums)
       
                                lo =False
                            z=z+1
                    except:
                        return 'No'
        if sum(row_sums)==0:
            return "Yes"
        else:
            return 'No'
  
    
    
matrix_size = input('').split(' ')
row_sum = input('').split(' ')
column_sum = input('').split(' ')

metrix_size = [int(i) for i in matrix_size]
row_sum = sorted([int(i) for i in row_sum], reverse=True)
column_sum = sorted([int(i) for i in column_sum], reverse=True)



testet = test(row_sum, column_sum, metrix_size)
print(testet)
