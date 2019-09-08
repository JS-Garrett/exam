/**
 * Map转json
 * @param obj
 * @returns String
 */
function MapTOJson(obj) {
    var str = '{';
    var i = 1;
    obj.forEach(function (item, key, mapObj) {
    	if(mapObj.size == i){
    		str += '"'+ key+'":"'+ item + '"';
    	}else{
    		str += '"'+ key+'":"'+ item + '",';
    	}
    	i++;
    });
    str +='}';
    return str;
}

