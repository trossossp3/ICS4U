function consoleTest(){
  //  console.log("if you need");
    var x='text';
   
    //console.log(x);


    var arr = [];

   
   // console.log(arr);

    var obj = {};

    obj.color = 'red';
    obj.height = 80;

    arr[6] = 'test';
    arr[8] = 3;
    arr[9]=[]; 
    arr[10]=obj;
   

    obj['shoesize']='small';
    obj[10] = 'why?';

    obj.func1 = function(){alert('I am funct 1');}

   // console.log(obj);
//    obj.func1();

    obj['myQueen']=Queen(7,8);
    console.log();
    console.log(obj);

    iterator(arr);

    mystery(1,'hello');

}

function iterator(coll){
    for(var val in coll){
        if (val!==undefined){
            console.log('key: '+val);
        }
        
    }
}

function Queen(row,col){
    var queen = {};
    this.row = row;
    this.col = col;

    return queen;
}

function mystery(a,b,c,d){
    console.log(a);
    console.log(b)
    console.log(c)
    console.log(d)
}
























