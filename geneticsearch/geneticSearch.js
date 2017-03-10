   function search_in_string(line_S, line_L) {
    var n = 0;
    pos = 0;
    while (true) {
      pos = line_L.indexOf(line_S, pos);
      if (pos >= 0) {
        ++n;
        pos += 1;
      } else break;
    }
    return n;
  }

  function type_1(line_S, line_L) {

    return search_in_string(line_S, line_L);
  }

  function type_2(line_S, line_L) {

    var temp_counter = 0;
    var line_s_minus_one_character = [];
    for (i = 0; i < line_S.length; i++) {
       var test =line_S.substring(0-1,i) + line_S.substring(i+1, line_S.length);
          line_s_minus_one_character.push(test);
    }
    var unique = line_s_minus_one_character.filter(function() {
      var seen = {};
      return function(element, index, array) {
        return !(element in seen) && (seen[element] = 1);
      };
    }());
    for (i = 0; i < unique.length; i++) {
      temp_counter = temp_counter + search_in_string(unique[i], line_L);
    }
    return temp_counter;
  }

  function type_3(line_S, line_L) {

    var temp_counter = 0;
    var dna_chars = "ACTG";
    var line_s_plus_one_character = [];

    for (i = 0; i <= line_S.length; i++) {
      for (j = 0; j < dna_chars.length; j++) {
        line_s_plus_one_character.push(line_S.slice(0, i) + dna_chars[j] + line_S.slice(i));
      }
    }
    var unique = line_s_plus_one_character.filter(function() {
      var seen = {};
      return function(element, index, array) {
        return !(element in seen) && (seen[element] = 1);
      };
    }());
    for (i = 0; i < unique.length; i++) {
      temp_counter = temp_counter + search_in_string(unique[i], line_L);
    }
    return temp_counter;
  }
var line;
 while (line = readline()) {
    if ((line != "0")||(line != 0)) {
    var lines = line.split(' ');
    var result_type_1 = type_1(lines[0],lines[1]);
    var result_type_2 = type_2(lines[0],lines[1]);
    var result_type_3 = type_3(lines[0],lines[1]);
    var result = result_type_1+" "+result_type_2+" "+result_type_3;
    print(result);
    }else break;
}

