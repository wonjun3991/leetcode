var addBinary = function(a, b) {
            var aLen=a.length-1;
        var bLen=b.length-1;
        var c=0;
        var s="";
        while(aLen >=0 || bLen >=0 || c===1){
            c+=aLen>=0 ? parseInt(a[aLen--]):0;
            c+=bLen>=0 ? parseInt(b[bLen--]):0;

            s=(c%2)+s;
            c=parseInt(c/2)
        }
        return s;
};