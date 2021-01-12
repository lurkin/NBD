var waga = function() {
    var bmi = parseFloat(this.weight) / ((parseFloat(this.height)) * (parseFloat(this.height))) * 10000
    var s = { count: 1, min: bmi, sum: bmi, max: bmi }
    emit(this.nationality, s)



}
var plec = function(s, w) {
    var result = { count: 0, min: 100, sum: 0, max: 0 }
    var sum = 0, c = 0
    for (var i = 0; i < w.length; i++) {
        result.sum += w[i].sum;
        result.count += w[i].count
        if (w[i].min < result.min) {
            result.min = w[i].min;
        } if (w[i].max > result.max) {
            result.max = w[i].max;
        }
    }
    return result

}
var fin = function(k, b) {
    var a = b.sum / b.count;
    var tar = { count: b.count, min: b.min, avg: a, max: b.max }
    return tar
}

db.people.mapReduce(waga, plec, { query: {}, out: "zad4Map" ,finalize: fin})