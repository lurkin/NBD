var waga = function() {
    for(var i = 0 ; i < this.credit.length; i++){
        emit(this.credit[i].currency, parseFloat(this.credit[i].balance))
        
    }
    
    
    
}
var plec = function(s , w) {
    
    return Array.sum(w)
}

db.people.mapReduce(waga, plec, { query: {}, out: "zad2Map" })