var waga = function() {
    for (var i = 0; i < this.credit.length; i++) {
        var c = { count: 1, balance: parseFloat(this.credit[i].balance) }
        emit(this.credit[i].currency, c)

    }



}
var plec = function(s, w) {
    var result = { count: 0, balance: 0 }
    for (var i = 0; i < w.length; i++) {
        result.count += w[i].count
        result.balance += w[i].balance
    }
    return result;

}

var fin = function(k, b) {
    var avg = b.balance / b.count
    var result = { count: b.count, avg: avg, sum: b.balance }
    return result
}

db.people.mapReduce(waga, plec, { query: { sex: "Female", nationality: "Poland" }, out: "zad5Map", finalize: fin })