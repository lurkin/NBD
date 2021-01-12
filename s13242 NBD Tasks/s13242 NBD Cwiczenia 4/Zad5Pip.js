db.people.aggregate([{ $unwind: "$credit" }, { $group: { _id: "$credit.currency", avg: { $avg: { $toDouble: "$credit.balance" } }, sum: { $sum: { $toDouble: "$credit.balance" } } }])
