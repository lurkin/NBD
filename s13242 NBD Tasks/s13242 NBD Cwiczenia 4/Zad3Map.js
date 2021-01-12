var waga = function() {
    emit(this.job,1)
}
var plec = function(s , w) {
    
    return Array.sum(w)
}

db.people.mapReduce(waga, plec, { query: {}, out: "zad3Map" })