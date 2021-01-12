
var waga = function() {
    var c = {count:1, weight:this.weight, x:1}
    emit(this.sex, c)
}
var plec = function(s , w) {
     var reduced = {  count: 0, weight: 0,x:1 }
    for(var i = 0 ; i<w.length; i++){
     reduced.count += w[i].count;
     reduced.weight += w[i].weight;
     
    }
    return reduced
}
var fin = function(k, m){
    return m.weight/m.count
}
db.people.mapReduce(waga, plec, { query: {}, out: "Zad1Map", finalize: fin })