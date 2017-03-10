function check_metrix(row_sums, column_sums, metrx_size) {

  if (metrx_size[0] > metrx_size[1]) {
    var temp = column_sums;
    var column_sums = row_sums;
    var row_sums = temp;
  }
  row_sums = row_sums.sort(function(a, b){return b-a})
  for (i = 0; i < row_sums.length; i++) {
    column_sums = column_sums.sort(function(a, b){return b-a})
    for (j = 0; j < row_sums[i]; j++) {

      if (column_sums[j] != 0) {
        column_sums[j] = column_sums[j] - 1;

      } else if (column_sums[j] == 0) {
        var z = j;
        var lo  = true;
        try {
        
          while (lo) {
            if (column_sums[z] != 0) {
              column_sums[z] = column_sums[z] - 1;
              lo= false;
              break;
            }
            z=z+1;

            
          }
        } catch (e) {
          return 'No';
        }
      }
    }
  }
  
   column_tot = column_sums.reduce(function(pv, cv) { return pv + cv; }, 0);
   if (column_tot ==0){
    return 'Yes';
   }else return 'No';
}

metrx_size =  readline().split(' ').map(function(num) {
  return parseInt(num);
})
column_sums =  readline().split(' ').map(function(num) {
  return parseInt(num);
})
row_sums =  readline().split(' ').map(function(num) {
  return parseInt(num);
})

test =check_metrix(row_sums, column_sums, metrx_size)
print(test)
